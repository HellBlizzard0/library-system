import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { url } from 'inspector';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}
  link: string = 'localhost:8080/login';

  login(username: string, password: string) {
    this.http.post(this.link, {
      username: username,
      password: password,
    });
  }
}
function body(link: string, body: any) {
  throw new Error('Function not implemented.');
}
