import { HttpErrorResponse, HttpEvent, HttpHandler, HttpHeaders, HttpInterceptor, HttpRequest } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { BehaviorSubject, catchError, filter, Observable, switchMap, take, throwError } from "rxjs";
import { StoreService } from "./store.service";
import { AuthService } from "./auth.service";
import { Router } from "@angular/router";

@Injectable({
    providedIn: 'root'
})
export class AppHttpInterceptor implements HttpInterceptor {

    /*
    Reference from below links
    https://stackblitz.com/edit/angular-9-jwt-authentication-example
    https://www.bezkoder.com/angular-12-refresh-token
    */
    isRefreshing: boolean = false;
    private refreshTokenSubject: BehaviorSubject<any> = new BehaviorSubject<any>(null);


    constructor(private storeService: StoreService, private authService: AuthService, private router: Router) { }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        //console.log("in interceptor")
        let cloneReq = req.clone({
            setHeaders: {
                'Content-Type': 'application/json; charset=utf-8',
                'Accept': 'application/json',
                'Authorization': 'Bearer ' + this.storeService.getAuthToken()
            }
        });
        //console.log(cloneReq.headers)
        return next.handle(cloneReq).pipe(catchError((error) => {
            console.log("Hello in error", error)
            const token = this.storeService.getAuthToken();
            if (error instanceof HttpErrorResponse && error.status === 401 && !!token) {
                return this.handle401Error(cloneReq, next);
            }
            return throwError(() => error);
        }));

    }
    private handle401Error(request: HttpRequest<any>, next: HttpHandler) {
        if (!this.isRefreshing) {
            this.isRefreshing = true;
            this.refreshTokenSubject.next(null);
            const token = this.storeService.getAuthToken();
            if (token)
                return this.authService.refreshToken(token).pipe(
                    switchMap((token: any) => {
                        this.isRefreshing = false;
                        this.storeService.storeAuthToken(token.token);
                        this.refreshTokenSubject.next(token.token);

                        return next.handle(this.addTokenHeader(request, token.token));
                    }),
                    catchError((err) => {
                        this.isRefreshing = false;

                        this.storeService.removeToken();
                        return throwError(err);
                    })
                );
        } else {
            this.router.navigate(['/login'])
        }

        return this.refreshTokenSubject.pipe(
            filter(token => token !== null),
            take(1),
            switchMap((token) => next.handle(this.addTokenHeader(request, token)))
        );
    }
    private addTokenHeader(request: HttpRequest<any>, token: string) {
        /* for Spring Boot back-end */
        // return request.clone({ headers: request.headers.set(TOKEN_HEADER_KEY, 'Bearer ' + token) });
        /* for Node.js Express back-end */
        return request.clone({ headers: request.headers.set('Authorization', 'Bearer ' + this.storeService.getAuthToken()) });
    }

}