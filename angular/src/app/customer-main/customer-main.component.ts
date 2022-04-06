import { Component, OnInit, HostListener } from '@angular/core';
import { LoginService } from '../backend/login.service';
import { User } from '../util/data/user';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css'],
})
export class CustomerMainComponent implements OnInit {
  // userData: any;
  customer!: User;

  constructor(private loginService: LoginService) {}

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
    this.customer = this.loginService.user;
    this.loginService.userSubject.subscribe((data) => (this.customer = data));
  }

  // Responsive control
  yourVisibleVaraible: any;
  baseZIndex = 2;
  mobile = false;
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
