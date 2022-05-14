import { Injectable } from "@angular/core";


@Injectable({
    providedIn:'root'
})
export class AuthService {
    
    private autheticated: boolean = false;

    authenticateUser(userName:string, password:string): boolean {
        if ( userName == 'admin' && password == 'test' ) {
            this.autheticated = true;
            return true;
          } else {
            alert("Invalid details")
            return false;
          }
    }

    isAuthenticated(): boolean {
        return this.autheticated;
    }

    logOut() {
        this.autheticated = false;
    }

}