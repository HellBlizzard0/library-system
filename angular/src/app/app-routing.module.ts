import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './customer-main/books/books.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { ProfileComponent } from './customer-main/profile/profile.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: '/customer', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'customer',
    component: CustomerMainComponent,
    children: [
      { path: '', redirectTo: '/customer/profile', pathMatch: 'full' },
      { path: 'books', component: BooksComponent },
      { path: 'profile', component: ProfileComponent },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
