import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { User } from '../util/data/user';

const LINKBASE = 'http://localhost:8080/api/User/';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  user = new Subject<User>();
  constructor(private http: HttpClient, private router: Router) {}
  updateUser(user: User) {
    const formData = new FormData();
    formData.append('id', user.id + '');
    formData.append('name', user.name + '');
    formData.append('username', user.username + '');
    formData.append('password', user.password + '');
    formData.append('enabled', user.enabled + '');
    formData.append('phoneNumber', user.phoneNumber + '');
    this.http.post(LINKBASE + 'updateUser', user).subscribe((data) => {
      console.log(data);
    });
  }
}
