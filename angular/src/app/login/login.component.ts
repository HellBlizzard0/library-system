import { Component, OnInit } from '@angular/core';
import { LoginService } from '../backend/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  isLoginMode: boolean = true;
  constructor(private loginService: LoginService) {}
  ngOnInit(): void {}
  onSubmit() {
    // Reserved for Spring Boot Integration
    // const result = this.loginService.login(this.username, this.password);
    // console.log(result);

    console.log({
      Submitted: 'FALSE',
      username: this.username,
      password: this.password,
    });
  }
  switchMode() {
    this.isLoginMode = !this.isLoginMode;
  }
}
