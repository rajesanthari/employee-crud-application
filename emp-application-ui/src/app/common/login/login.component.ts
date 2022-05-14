import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../shared/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userForm: FormGroup;

  constructor(private formBuilder:FormBuilder, private router:Router,private authService:AuthService) { }

  ngOnInit(): void {
    this.userForm = this.formBuilder.group({
      userName:['',[Validators.required, Validators.minLength(5)]],
      password: ['', [Validators.required]]
    });
  }

  onLoginClick() {
    if( this.userForm.valid ) {
      let credentials = this.userForm.value
      let isAuth = this.authService.authenticateUser(credentials.userName, credentials.password);
      if ( isAuth ) {
        this.router.navigate(['auth']);
      }

    }
  }

}
