import { Injectable } from "@angular/core";

@Injectable({
    providedIn:'root'
})
export class StoreService {

    private AUTH_TOKEN_KEY: string = 'auth_token';


    storeAuthToken(token:string) {
        localStorage.setItem(this.AUTH_TOKEN_KEY, token);
    }

    getAuthToken(): string|null {
        return localStorage.getItem(this.AUTH_TOKEN_KEY);
    }

    isAuthenticated(): boolean {
        return !!this.getAuthToken();
    }

    removeToken() {
        localStorage.removeItem(this.AUTH_TOKEN_KEY);
    }


}