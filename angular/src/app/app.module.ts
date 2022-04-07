import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardModule } from 'primeng/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PasswordModule } from 'primeng/password';

import { InputTextModule } from 'primeng/inputtext';
import { ButtonModule } from 'primeng/button';
import { LoginComponent } from './login/login.component';
import { LoginService } from './backend/login.service';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SidebarModule } from 'primeng/sidebar';
import { TabViewModule } from 'primeng/tabview';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { BooksComponent } from './shared/books/books.component';
import { BookService } from './backend/book.service';
import { TableModule } from 'primeng/table';
import { PrimeNGConfig } from 'primeng/api';
import { DataViewModule } from 'primeng/dataview';
import { PanelModule } from 'primeng/panel';
import { DropdownModule } from 'primeng/dropdown';
import { Dialog, DialogModule } from 'primeng/dialog';
import { RatingModule } from 'primeng/rating';
import { RippleModule } from 'primeng/ripple';
import { PasswordPipe } from './util/password.pipe';
import { LibrarianMainComponent } from './librarian-main/librarian-main.component';
import { BorrowComponent } from './shared/borrow/borrow.component';
import { ProfileComponent } from './shared/profile/profile.component';
import { CustomersComponent } from './librarian-main/customers/customers.component';

import { ToastModule } from 'primeng/toast';
// import { CalendarModule } from 'primeng/calendar';
// import { SliderModule } from 'primeng/slider';
// import { MultiSelectModule } from 'primeng/multiselect';
// import { ContextMenuModule } from 'primeng/contextmenu';
// import { ProgressBarModule } from 'primeng/progressbar';
// import { FileUploadModule } from 'primeng/fileupload';
import { ToolbarModule } from 'primeng/toolbar';
// import { RadioButtonModule } from 'primeng/radiobutton';
// import { InputNumberModule } from 'primeng/inputnumber';
// import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
// import { InputTextareaModule } from 'primeng/inputtextarea';
import { UserService } from './backend/user.service';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogService, DynamicDialogModule } from 'primeng/dynamicdialog';
import { SliderModule } from 'primeng/slider';
import { TranslateService } from '@ngx-translate/core';
import { TranslateModule, TranslateLoader } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { I18nServiceService } from './i18n-service/i18n-service.service';

export function HttpLoaderFactory(http: HttpClient) {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
}
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerMainComponent,
    BooksComponent,
    ProfileComponent,
    PasswordPipe,
    BorrowComponent,
    LibrarianMainComponent,
    CustomersComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CardModule,
    PasswordModule,
    FormsModule,
    InputTextModule,
    ButtonModule,
    HttpClientModule,
    NgbModule,
    SidebarModule,
    TabViewModule,
    BrowserAnimationsModule,
    TableModule,
    DataViewModule,
    PanelModule,
    DialogModule,
    DropdownModule,
    RippleModule,
    RatingModule,
    ReactiveFormsModule,
    ToastModule,
    ToolbarModule,
    ConfirmDialogModule,
    DynamicDialogModule,
    SliderModule,
    TranslateModule.forRoot({
      loader: {
        provide: TranslateLoader,
        useFactory: HttpLoaderFactory,
        deps: [HttpClient],
      },
      isolate: true,
    }),
  ],
  providers: [
    LoginService,
    UserService,
    HttpClient,
    BookService,
    PrimeNGConfig,
    MessageService,
    ConfirmationService,
    DialogService,
    TranslateService,
    I18nServiceService,
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
