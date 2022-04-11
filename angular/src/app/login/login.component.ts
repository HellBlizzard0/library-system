import { Component, OnInit } from '@angular/core';
import { LoginService } from '../backend/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string = 'lib2';
  password: string = '123';
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
    this.isLoginMode = !this.isLoginMode;
  }
}
