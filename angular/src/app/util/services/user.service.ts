import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { User } from '../data/user';

const LINKBASE_C = 'http://localhost:8080/api/Customer/';
const LINKBASE_L = 'http://localhost:8080/api/Librarian/';
@Injectable({
  providedIn: 'root',
})
export class UserService {
  users: User[] = [];
  userSubject = new Subject<User[]>();

  constructor(private http: HttpClient, private router: Router) {}
  updateUser(user: User, isCustomer: boolean) {
    // const formData = new FormData();
    // formData.append('id', user.id + '');
    // formData.append('name', user.name + '');
    // formData.append('username', user.username + '');
    // formData.append('password', user.password + '');
    // formData.append('enabled', user.enabled + '');
    // formData.append('phoneNumber', user.phoneNumber + '');

    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    };

    if (isCustomer)
      this.http
        .post(LINKBASE_C + 'updateCustomer', user, httpOptions)
        .subscribe((data) => {
          console.log(data);
        });
    else
      this.http
        .post(LINKBASE_L + 'updateLibrarian', user, httpOptions)
        .subscribe((data) => {
          console.log(data);
        });
  }

  getAllCustomers() {
    this.users = [];
    this.http.get(LINKBASE_C + 'getAllCustomers').subscribe((data: any) => {
      data.forEach((element: User) => {
        this.users.push(element);
      });
      // console.log(data);

      this.userSubject.next(this.users);
    });
  }

  getAllCustomersWithBorrowCount() {
    this.users = [];
    this.http
      .get(LINKBASE_C + 'getAllCustomersWithBorrowCount')
      .subscribe((data: any) => {
        data.forEach((element: any) => {
          this.users.push(this.toCustomerWithBorrowCount(element));
        });
        // console.log(data);

        this.userSubject.next(this.users);
      });
  }
  toCustomerWithBorrowCount(data: any): User {
    return {
      name: data.customer.name,
      username: data.customer.username,
      id: data.customer.id,
      dateOfCreation: data.customer.dateOfCreation,
      lastUpdate: data.customer.lastUpdate,
      borrowCount: data.borrowCount,
    };
  }
}
