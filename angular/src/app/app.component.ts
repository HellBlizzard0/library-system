import { Component } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import { I18nServiceService } from './util/services/i18n-service.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  title = 'ngx-i18n';

  constructor(
    translate: TranslateService,
    private i18nService: I18nServiceService
  ) {
    translate.setDefaultLang('en');
    translate.use('en');
  }
}
