import { Component, Input, OnInit } from '@angular/core';
import { LoginService } from 'src/app/backend/login.service';
import { Customer } from 'src/app/data/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isEditMode = false;
  customer: Customer = {
    id: 0,
    dateOfCreation: new Date(),
    lastUpdated: new Date(),
    enabled: false,
    username: '',
    password: '',
    name: 'N/A',
    phoneNumber: '',
  };
  constructor(private loginService: LoginService) {
    // this.loginService.userData.subscribe((data) => {
    //   this.customer = this.loginService.toCustomer(data);
    //   // console.log(this.customer);
    // });
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
  // ngOnDestroy() {
  //   this.loginService.data.unsubscribe();
  // }
  onSubmit() {}
  onSwitchEditMode() {
    this.isEditMode = !this.isEditMode;
  }

  print() {
    console.log(this.customer);
  }
}
