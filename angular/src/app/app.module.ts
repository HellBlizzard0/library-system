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
import { DialogModule } from 'primeng/dialog';
import { RatingModule } from 'primeng/rating';
import { RippleModule } from 'primeng/ripple';
import { PasswordPipe } from './util/password.pipe';
import { LibrarianMainComponent } from './librarian-main/librarian-main.component';
import { BorrowComponent } from './shared/borrow/borrow.component';
import { ProfileComponent } from './shared/profile/profile.component';
import { CustomersComponent } from './librarian-main/customers/customers.component';

import { ToastModule } from 'primeng/toast';
import { CalendarModule } from 'primeng/calendar';
import { SliderModule } from 'primeng/slider';
import { MultiSelectModule } from 'primeng/multiselect';
import { ContextMenuModule } from 'primeng/contextmenu';
import { ProgressBarModule } from 'primeng/progressbar';
import { FileUploadModule } from 'primeng/fileupload';
import { ToolbarModule } from 'primeng/toolbar';
import { RadioButtonModule } from 'primeng/radiobutton';
import { InputNumberModule } from 'primeng/inputnumber';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ConfirmationService } from 'primeng/api';
import { MessageService } from 'primeng/api';
import { InputTextareaModule } from 'primeng/inputtextarea';
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
  ],
  providers: [
    LoginService,
    HttpClient,
    BookService,
    PrimeNGConfig,
    MessageService,
    ConfirmationService,
  ],
  bootstrap: [AppComponent],
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
})
export class AppModule {}
