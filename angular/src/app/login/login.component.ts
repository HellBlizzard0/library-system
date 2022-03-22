import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  username: string = '';
  password: string = '';
  isLoginMode: boolean = true;
  constructor() {}
  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }
  onSubmit() {}
  switchMode() {
    this.isLoginMode = !this.isLoginMode;
  }
}
