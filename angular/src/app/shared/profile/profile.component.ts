import { Component, Input, OnInit } from '@angular/core';
import {
  FormControl,
  FormControlName,
  FormGroup,
  Validators,
} from '@angular/forms';
import { UserService } from 'src/app/backend/user.service';
import { LoginService } from 'src/app/backend/login.service';
import { User } from 'src/app/util/data/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isEditMode!: boolean;
  user!: User;

  constructor(
    private loginService: LoginService,
    private userService: UserService
  ) {
    // this.loginService.userData.subscribe((data) => {
    //   this.user = this.loginService.toCustomer(data);
    //   // console.log(this.user);
    // });
    this.isEditMode = false;
  }

  ngOnChange() {}

  ngOnInit(): void {
    this.user = this.loginService.user;
    this.loginService.subject.subscribe((data) => (this.user = data));

    // this.loginService.userData.subscribe(() => {
    //   this.user = this.loginService.toCustomer();
    //   // console.log(data);

    //   console.log(this.user);
    // });
    // this.user = this.loginService.toCustomer(this.loginService.userData);
  }
  ngOnDestroy() {
    this.loginService.subject.unsubscribe();
    this.user = {};
  }
  onSubmit() {
    this.loginService.subject.next(this.user);
    this.userService.updateUser(this.user);
    this.isEditMode = !this.isEditMode;
  }
  onSwitchEditMode() {
    this.isEditMode = !this.isEditMode;
  }

  print() {
    console.log(this.user);
  }
}
