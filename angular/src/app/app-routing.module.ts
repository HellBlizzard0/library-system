import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './shared/books/books.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './shared/profile/profile.component';
import { BorrowComponent } from './shared/borrow/borrow.component';
import { LibrarianMainComponent } from './librarian-main/librarian-main.component';
import { CustomersComponent } from './librarian-main/customers/customers.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'customer',
    component: CustomerMainComponent,
    children: [
      { path: '', redirectTo: '/customer/profile', pathMatch: 'full' },
      { path: 'books', component: BooksComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'borrow', component: BorrowComponent },
    ],
  },
  {
    path: 'librarian',
    component: LibrarianMainComponent,
    children: [
      { path: '', redirectTo: '/librarian/books', pathMatch: 'full' },
      { path: 'books', component: BooksComponent },
      { path: 'customers', component: CustomersComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'borrow', component: BorrowComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
