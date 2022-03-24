import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CardModule } from 'primeng/card';
import { FormsModule } from '@angular/forms';
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
import { BookPanelComponent } from './books/book-panel/book-panel.component';
@NgModule({
  declarations: [AppComponent, LoginComponent, CustomerMainComponent, BooksComponent, BookPanelComponent],
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
  ],
  providers: [LoginService, HttpClient],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
