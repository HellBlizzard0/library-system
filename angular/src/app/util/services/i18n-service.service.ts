import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { TranslateService } from '@ngx-translate/core';
import { Direction } from '@angular/cdk/bidi';

@Injectable({
  providedIn: 'root',
})
export class I18nServiceService {
  localeEvent = new Subject<string>();
  dir = new Subject<Direction>();

  constructor(private translate: TranslateService) {
    translate.setDefaultLang('en');
    translate.use('en');
    this.dir.next('ltr');
  }

  changeLocale(locale: string) {
    this.translate.use(locale);
    this.localeEvent.next(locale);
    switch (locale) {
      case 'en':
        this.dir.next('ltr');
        break;
      case 'ar':
        this.dir.next('rtl');
        break;
    }
  }

  get(label: string): string {
    let res: string = 'N/A';
    this.translate.get(label).subscribe((data: string) => {
      res = data;
    });
    return res;
  }

  isEnglish() {
    return this.translate.currentLang == 'en';
  }
}
