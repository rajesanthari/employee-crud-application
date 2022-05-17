import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { EventEmitter, Injectable } from "@angular/core";
import { catchError, Subject, throwError } from "rxjs";
import { environment } from "src/environments/environment";
import { ResponseToken } from "./response.token.model";
import { StoreService } from "./store.service";


@Injectable({
    providedIn:'root'
})
export class AuthService {

   private  authenticationStatus: Subject<boolean> = new Subject<boolean>();

    autheticationEndPoint:string = environment.restapiinfo.endpoint_url+environment.restapiinfo.resources.authenticate;

    refreshTokenEndPoint:string = environment.restapiinfo.endpoint_url+environment.restapiinfo.resources.refresh_token;

    constructor(private httpClient:HttpClient,private storeService:StoreService){}
    
    private autheticated: boolean = false;

    authenticateUser(userName:string, password:string) {
        this.httpClient.post<ResponseToken>(this.autheticationEndPoint, {username: userName, password:password}).subscribe({
            next: (val) => {
                this.storeService.storeAuthToken(val.token);
                this.authenticationStatus.next(true);
            },
            error: (error) => {
                console.log("in error ",error)
                alert('Authentication failed. more details in console log')
                if (error.error instanceof ErrorEvent) {
                  // A client-side or network error occurred. Handle it accordingly.
                  console.error('An error occurred:', error.error.message);
                } else {
                  // The backend returned an unsuccessful response code.
                  // The response body may contain clues as to what went wrong,
                  console.error(
                    `Backend returned code ${error.status}, ` +
                    `body was: ${error.error}`);

                }
            }
        })
       
    }

    refreshToken(token: string) {
        return this.httpClient.get(this.refreshTokenEndPoint,{headers: new HttpHeaders({'isRefreshToken': 'true'})});
      }

    isAuthenticated(): boolean {
        return this.storeService.isAuthenticated();
    }

    logOut() { 
        this.storeService.removeToken();
    } 

    getAutheticationStatus():Subject<boolean> {
        return this.authenticationStatus;
    }

}