import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User } from '../data/user';
import { Router } from '@angular/router';
@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient, private router: Router) {}
  link: string = 'http://localhost:8080/api/User/login';
  isUserLoggedIn = false;
  user!: User;

  login(username: string, password: string) {
    console.log('username: ' + username);
    console.log('password: ' + password);
    console.log('link: ' + this.link);

    const formData = new FormData();
    formData.append('username', username);
    formData.append('password', password);
    console.log(formData);

    this.http.post(this.link, formData).subscribe(
      (data: any) => {
        switch (data['role']) {
          case null:
            console.log('Error: Wrong Username/Password');
            break;
          case 'CUSTOMER':
            // console.log(data);
            console.log('CUSTOMER');
            this.isUserLoggedIn = true;
            this.user = data['data'];
            console.log(this.user);
            this.router.navigateByUrl('/customer');
            break;
          case 'LIBRARIAN':
            // console.log(data);
            console.log('LIBRARIAN');
            this.isUserLoggedIn = true;
            this.user = data['data'];
            console.log(this.user);
            this.router.navigateByUrl('/customer');
            break;
        }
      },
      (error) => {
        console.log('Error: ' + error);
      }
    );
  }
}
