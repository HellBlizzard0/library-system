import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../util/data/user';
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
  user!: User;
  userSubject = new Subject<User>();

  login(username: string, password: string) {
    this.userSubject.next({});
    console.log('username: ' + username);
    console.log('password: ' + password);
    console.log('link: ' + this.link);

    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);

    // ====================
    this.http.post(this.link, formData).subscribe(
      (data: any) => {
        switch (data['role']) {
          case null:
            console.log('Error: Wrong Username/Password');
            break;
          case 'CUSTOMER':
            console.log('CUSTOMER');

            this.user = this.toUser(data, 'ROLE_CUSTOMER');
            this.userSubject.next(this.user);

            this.isUserLoggedIn = true;
            this.isCustomer = true;
            this.router.navigate(['/customer']);
            break;
          case 'LIBRARIAN':
            console.log('LIBRARIAN');

            this.user = this.toUser(data, 'ROLE_LIBRARIAN');
            this.userSubject.next(this.user);

            this.isCustomer = false;
            this.isUserLoggedIn = true;
            this.router.navigateByUrl('/customer');
            break;
        }
      },
      (error) => {
        console.log(error);
      }
    );
  }

  getUser(): User {
    return this.user;
  }

  toUser(data: any, role: string): User {
    console.log(data);

    switch (role) {
      case 'ROLE_CUSTOMER':
        return {
          id: data['data'].id,
          dateOfCreation: data['data'].dateOfCreation,
          lastUpdate: data['data'].lastUpdate,
          enabled: data['data'].enabled,
          username: data['data'].username,
          password: data['data'].password,
          name: data['data'].name,
          phoneNumber: data['data'].phoneNumber,
          role: role,
        };
      case 'ROLE_LIBRARIAN':
        return {
          id: data['data'].id,
          dateOfCreation: data['data'].dateOfCreation,
          lastUpdate: data['data'].lastUpdate,
          enabled: data['data'].enabled,
          username: data['data'].username,
          password: data['data'].password,
          name: data['data'].name,
          // phoneNumber: data['data'].phoneNumber,
          role: role,
        };
      default:
        return {};
        break;
    }
  }
}
