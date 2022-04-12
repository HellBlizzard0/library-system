import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './main/books/books.component';
import { MainComponent } from './main/main.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './main/profile/profile.component';
import { BorrowComponent } from './main/borrow/borrow.component';
import { CustomersComponent } from './main/customers/customers.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'customer',
    component: MainComponent,
    children: [
      { path: '', redirectTo: '/customer/books', pathMatch: 'full' },
      { path: 'books', component: BooksComponent },
      { path: 'profile', component: ProfileComponent },
      { path: 'borrow', component: BorrowComponent },
    ],
  },
  {
    path: 'librarian',
    component: MainComponent,
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
