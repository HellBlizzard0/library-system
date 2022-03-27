import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Customer } from '../data/user';

@Injectable({
  providedIn: 'root',
})
export class CustomerService {
  customer = new Subject<Customer>();
  constructor() {}
}
