import { Component, OnInit, OnChanges, HostListener } from '@angular/core';
import { LoginService } from '../backend/login.service';
import { Customer } from '../data/user';
import { CustomerService } from './customer.service';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css'],
})
export class CustomerMainComponent implements OnInit {
  yourVisibleVaraible: any;
  baseZIndex = 2;
  mobile = false;
  // userData: any;
  customer!: Customer;

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
    this.customer = this.loginService.cust;
    // this.customer = this.loginService.toCustomer(this.loginService.userData);
    this.loginService.subject.subscribe((data) => (this.customer = data));
  }

  // Responsive control
  maxWidth = 768;
  public getScreenWidth: any;
  @HostListener('window:resize', ['$event'])
  onWindowResize() {
    this.getScreenWidth = window.innerWidth;
  }

  // ngOnDestroy() {
  //   this.loginService.data.unsubscribe();
  // }
}
