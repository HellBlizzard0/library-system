import { Component, Input, OnInit } from '@angular/core';
import {
  FormControl,
  FormControlName,
  FormGroup,
  Validators,
} from '@angular/forms';
import { LoginService } from 'src/app/backend/login.service';
import { Customer, Librarian, User } from 'src/app/data/user';
import { CustomerService } from '../../backend/customer.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isEditMode!: boolean;
  customer!: Customer;
  librarian!: Librarian;
  constructor(
    private loginService: LoginService,
    private customerService: CustomerService
  ) {
    // this.loginService.userData.subscribe((data) => {
    //   this.customer = this.loginService.toCustomer(data);
    //   // console.log(this.customer);
    // });
    this.isEditMode = false;
  }

  ngOnChange() {}

  ngOnInit(): void {
    this.customer = this.loginService.cust;
    this.loginService.subject.subscribe((data) => (this.customer = data));

    // this.loginService.userData.subscribe(() => {
    //   this.customer = this.loginService.toCustomer();
    //   // console.log(data);

    //   console.log(this.customer);
    // });
    // this.customer = this.loginService.toCustomer(this.loginService.userData);
  }
  ngOnDestroy() {
    this.loginService.subject.unsubscribe();
    this.customer = {};
    this.librarian = {};
  }
  onSubmit() {
    this.loginService.subject.next(this.customer);
    this.customerService.updateCustomer(this.customer);
    this.isEditMode = !this.isEditMode;
  }
  onSwitchEditMode() {
    this.isEditMode = !this.isEditMode;
  }

  print() {
    console.log(this.customer);
  }

  getUser(): User {
    if (this.customer.username != null) return this.customer;
    else return this.librarian;
  }
}
