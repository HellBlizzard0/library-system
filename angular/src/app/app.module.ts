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
import { BooksComponent } from './customer-main/books/books.component';
import { BookPanelComponent } from './customer-main/books/book-panel/book-panel.component';
import { BookService } from './backend/book.service';
import { TableModule } from 'primeng/table';
import { ProfileComponent } from './customer-main/profile/profile.component';
import { PrimeNGConfig } from 'primeng/api';
import { DataViewModule } from 'primeng/dataview';
import { PanelModule } from 'primeng/panel';
import { DropdownModule } from 'primeng/dropdown';
import { DialogModule } from 'primeng/dialog';
import { RatingModule } from 'primeng/rating';
import { RippleModule } from 'primeng/ripple';
import { PasswordPipe } from './util/password.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    CustomerMainComponent,
    BooksComponent,
    BookPanelComponent,
    ProfileComponent,
    PasswordPipe,
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
  ],
  providers: [LoginService, HttpClient, BookService, PrimeNGConfig],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
