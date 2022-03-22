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
  onSubmit() {}
  switchMode() {
    this.isLoginMode = !this.isLoginMode;
  }
}
