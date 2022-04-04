import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer, Librarian, User } from '../data/user';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { CustomerMainComponent } from '../customer-main/customer-main.component';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient, private router: Router) {
    if (!this.isUserLoggedIn) router.navigate(['/']);
  }
  link: string = 'http://localhost:8080/api/User/login';
  isUserLoggedIn = false;
  isCustomer = false;
  cust!: Customer;
  lib!: Librarian;
  subject = new Subject<any>();

  login(username: string, password: string) {
    // console.log('username: ' + username);
    // console.log('password: ' + password);
    // console.log('link: ' + this.link);

    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    // this.cust = {
    //   id: 0,
    //   name: 'Curtis Jackson',
    //   username: 'cjn',
    //   password: '111',
    //   enabled: true,
    //   dateOfCreation: new Date(),
    //   lastUpdated: new Date(),
    //   phoneNumber: '0500000000',
    // };
    // this.isCustomer = true;
    // this.subject.next(this.cust);
    // this.router.navigate(['/customer']);

    this.lib = {
      id: 0,
      name: 'Curtis Jackson',
      username: 'cjn',
      password: '111',
      enabled: true,
      dateOfCreation: new Date(),
      lastUpdated: new Date(),
    };
    this.isCustomer = false;
    this.subject.next(this.lib);
    this.router.navigate(['/librarian']);

    // ====================
    // this.http.post(this.link, formData).subscribe(
    //   (data: any) => {
    //     switch (data['role']) {
    //       case null:
    //         console.log('Error: Wrong Username/Password');
    //         break;
    //       case 'CUSTOMER':
    //         // console.log(data);
    //         console.log('CUSTOMER');
    //         this.isUserLoggedIn = true;
    //         this.cust = {
    //           id: data['data'].id,
    //           dateOfCreation: data['data'].dateOfCreation,
    //           lastUpdated: data['data'].lastUpdated,
    //           enabled: data['data'].enabled,
    //           username: data['data'].username,
    //           password: data['data'].password,
    //           name: data['data'].name,
    //           phoneNumber: data['data'].phoneNumber,
    //         };
    //         this.subject.next(this.cust);
    //         this.router.navigate(['/customer']);
    //         break;
    //       case 'LIBRARIAN':
    //         // console.log(data);
    //         console.log('LIBRARIAN');
    //         this.isUserLoggedIn = true;
    //         this.lib = {
    //           id: data['data'].id,
    //           dateOfCreation: data['data'].dateOfCreation,
    //           lastUpdated: data['data'].lastUpdated,
    //           enabled: data['data'].enabled,
    //           username: data['data'].username,
    //           password: data['data'].password,
    //           name: data['data'].name,
    //         };
    //         this.router.navigateByUrl('/customer');
    //         break;
    //     }
    //   },
    //   (error) => {
    //     console.log('Error: ' + error);
    //   }
    // );
  }

  // toCustomer(): Customer {
  //   console.log('User Data: ');

  //   console.log(this.userData);

  //   console.log(data);
  //   return {
  //     id: this.userData.id,
  //     username: this.userData.username,
  //     password: this.userData.password,
  //     enabled: this.userData.enabled,
  //     dateOfCreation: this.userData.dateOfCreation,
  //     lastUpdated: this.userData.lastUpdated,
  //     name: this.userData.name,
  //     phoneNumber: this.userData.phoneNumber,
  //   };
  //   return {
  //     id: 0,
  //     dateOfCreation: new Date(),
  //     lastUpdated: new Date(),
  //     enabled: false,
  //     username: '',
  //     password: '',
  //     name: 'N/A',
  //     phoneNumber: '',
  //   };
  // }
}
