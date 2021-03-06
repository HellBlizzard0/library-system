import { Direction } from '@angular/cdk/bidi';
import { Component, OnInit, HostListener } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { left } from '@popperjs/core';
import { LoginService } from '../util/services/login.service';
import { I18nServiceService } from '../util/services/i18n-service.service';
import { User } from '../util/data/user';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css'],
})
export class MainComponent implements OnInit {
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
    this.i18nService.changeLocale('en');
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
    return this.translate.currentLang == 'en';
  }

  isLibrarian() {
    return !this.loginService.isCustomer;
  }
}
