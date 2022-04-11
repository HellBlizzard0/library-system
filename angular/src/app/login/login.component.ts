import { Component, OnInit } from '@angular/core';
import { LoginService } from '../backend/login.service';
import { User } from '../util/data/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string = 'lib2';
  password: string = '123';
  newUser: User = {};
  isLoggedIn: boolean = true;
  isLoginMode: boolean = true;
  constructor(private loginService: LoginService) {}
  ngOnInit(): void {}
  onSubmit() {
    // Reserved for Spring Boot Integration
    this.loginService.login(this.username, this.password);

    // console.log({
    //   Submitted: 'FALSE',
    //   username: this.username,
    //   password: this.password,
    // });
  }
  switchMode() {
    this.isLoggedIn = !this.isLoggedIn;
  }

  switchToLogIn() {
    this.newUser = {};
    this.isLoginMode = true;
  }

  switchToSignUp() {
    this.username = '';
    this.password = '';
    this.isLoginMode = false;
  }

  signup() {
    this.loginService.signup(this.newUser);
  }
}
