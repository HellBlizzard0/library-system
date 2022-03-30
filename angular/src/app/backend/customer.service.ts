import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Customer } from '../data/user';

const LINKBASE = 'http://localhost:8080/api/Customer/';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  customer = new Subject<Customer>();
  constructor(private http: HttpClient, private router: Router) {}
  updateCustomer(customer: Customer) {
    const formData = new FormData();
    formData.append('id', customer.id + '');
    formData.append('name', customer.name + '');
    formData.append('username', customer.username + '');
    formData.append('password', customer.password + '');
    formData.append('enabled', customer.enabled + '');
    formData.append('phoneNumber', customer.phoneNumber + '');
    this.http.post(LINKBASE + 'updateCustomer', customer).subscribe((data) => {
      console.log(data);
    });
  }
}
