import { Direction } from '@angular/cdk/bidi';
import { Component, OnInit, HostListener } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { left } from '@popperjs/core';
import { LoginService } from '../backend/login.service';
import { I18nServiceService } from '../i18n-service/i18n-service.service';
import { User } from '../util/data/user';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css'],
})
export class CustomerMainComponent implements OnInit {
  // userData: any;
  customer!: User;
  dir: Direction = 'ltr';

  constructor(
    private loginService: LoginService,
    private translate: TranslateService,
    private i18nService: I18nServiceService
  ) {}

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
    this.customer = this.loginService.user;
    this.loginService.userSubject.subscribe((data) => (this.customer = data));
    this.i18nService.dir.subscribe((newDir) => {
      this.dir = newDir;
    });
  }

  // Responsive control
  yourVisibleVaraible: any;
  baseZIndex = 2;
  mobile = false;
  maxWidth = 768;
  public getScreenWidth: any;
  @HostListener('window:resize', ['$event'])
  onWindowResize() {
    this.getScreenWidth = window.innerWidth;
  }

  // ngOnDestroy() {
  //   this.loginService.data.unsubscribe();
  // }

  changeLocale(locale: string) {
    // console.log('changeLocale(' + locale + ')');

    this.i18nService.changeLocale(locale);
  }

  isEnglish() {
    console.log(this.translate.currentLang == 'en');
    return this.translate.currentLang == 'en';
  }
}
