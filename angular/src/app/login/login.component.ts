import { Component, OnInit } from '@angular/core';
import { LoginService } from 'src/app/util/services/login.service';
import { User } from 'src/app/util/data/user';
import { I18nServiceService } from '../util/services/i18n-service.service';
import { TranslateService } from '@ngx-translate/core';
import { Direction } from '@angular/cdk/bidi';

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
  dir!: Direction;
  constructor(
    private loginService: LoginService,
    private translate: TranslateService,
    private i18n: I18nServiceService
  ) {}
  ngOnInit(): void {
    console.log('isEnglish()=' + this.isEnglish());

    this.i18n.dir.subscribe((newDir) => {
      this.dir = newDir;
    });
    this.i18n.changeLocale('en');
  }
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

  isEnglish(): boolean {
    return this.translate.currentLang == 'en';
  }

  changeLang(lang: string) {
    this.i18n.changeLocale(lang);
  }
}
