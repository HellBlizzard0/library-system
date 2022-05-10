import { Direction } from '@angular/cdk/bidi';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/util/services/user.service';
import { I18nServiceService } from 'src/app/util/services/i18n-service.service';
import { User } from 'src/app/util/data/user';

@Component({
  selector: 'app-customers',
  templateUrl: './customers.component.html',
  styleUrls: ['./customers.component.css'],
})
export class CustomersComponent implements OnInit {
  customers: User[] = [];
  dir!: Direction;

  constructor(
    private userService: UserService,
    private i18nServiceService: I18nServiceService
  ) {}

  ngOnInit(): void {
    this.i18nServiceService.dir.subscribe((data) => {
      this.dir = data;
    });
    this.userService.userSubject.subscribe((data) => {
      this.customers = data;
    });
    this.userService.getAllCustomersWithBorrowCount();
    // this.customers = this.userService.users;
  }
}
