import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "./shared/auth.service";

@Component({
    selector: 'app-logout',
    template: ''
})
export class LogoutComponent implements OnInit {

    constructor(private router: Router, private authService: AuthService) { }

    ngOnInit(): void {
        this.authService.logOut();
        this.router.navigate(['login']);
    }


}