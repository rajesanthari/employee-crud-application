import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../shared/auth.service';
import { StoreService } from '../shared/store.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userForm: FormGroup;

  constructor(private formBuilder:FormBuilder, private router:Router,private authService:AuthService) { }

  ngOnInit(): void {
    this.navigateToAuth();
    this.userForm = this.formBuilder.group({
      userName:['',[Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required]]
    });
  }

  onLoginClick() {
    if( this.userForm.valid ) {
      let credentials = this.userForm.value
      this.authService.authenticateUser(credentials.userName, credentials.password);
      
      this.authService.getAutheticationStatus().subscribe(data => {
        if (data) {
          this.navigateToAuth();
        }
      });
    }
  }
  navigateToAuth() {
    if (this.authService.isAuthenticated() ) {
      this.router.navigate(['auth']);
    }
  }

}
