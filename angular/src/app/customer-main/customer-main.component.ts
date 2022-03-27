import { Component, OnInit, OnChanges, HostListener } from '@angular/core';
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

  customer!: Customer;

  constructor(private customerService: CustomerService) {
    this.customerService.customer.subscribe((data) => {
      this.customer = data;
    });
  }

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
  }

  // Responsive control
  maxWidth = 768;
  public getScreenWidth: any;
  @HostListener('window:resize', ['$event'])
  onWindowResize() {
    this.getScreenWidth = window.innerWidth;
  }
}
