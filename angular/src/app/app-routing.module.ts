import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BooksComponent } from './customer-main/books/books.component';
import { CustomerMainComponent } from './customer-main/customer-main.component';
import { LoginComponent } from './login/login.component';

const routes: Routes = [
  { path: '', redirectTo: '/customer', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  {
    path: 'customer',
    component: CustomerMainComponent,
    children: [{ path: 'books', component: BooksComponent }],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
