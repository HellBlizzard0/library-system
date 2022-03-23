import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}
  link: string = 'localhost:8080/api/User/login';

  login(username: string, password: string) {
    // console.log('username: ' + username);
    // console.log('password: ' + password);
    // console.log('link: ' + this.link);

    return this.http.post(this.link, {
      username: username,
      password: password,
    });
  }
}
function body(link: string, body: any) {
  throw new Error('Function not implemented.');
}
