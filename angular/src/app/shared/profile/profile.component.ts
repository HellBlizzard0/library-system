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
import { Direction } from '@angular/cdk/bidi';
import { I18nServiceService } from 'src/app/i18n-service/i18n-service.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isEditMode!: boolean;
  user!: User;
  border = 'border-0';
  dir!: Direction;

  constructor(
    private loginService: LoginService,
    private userService: UserService,
    private i18nServiceService: I18nServiceService
  ) {
    this.isEditMode = false;
  }

  ngOnChange() {}

  ngOnInit(): void {
    // this.loginService.userSubject.subscribe((data: User) => {
    //   this.user = data;
    // });
    this.i18nServiceService.dir.subscribe((dir) => {
      this.dir = dir;
    });
    this.user = this.loginService.user;
  }
  ngOnDestroy() {
    // this.loginService.userSubject.unsubscribe();
    this.user = {};
  }
  onSubmit() {
    console.log(this.user);

    this.loginService.userSubject.next(this.user);
    this.userService.updateUser(this.user, this.loginService.isCustomer);
    this.onSwitchEditMode();
  }
  onSwitchEditMode() {
    this.isEditMode = !this.isEditMode;
    if (this.isEditMode) this.border = 'border-1';
    else this.border = 'border-0';
  }

  print() {
    // console.log(this.loginService.user);
    // console.log(this.user);
  }

  isCustomer(): boolean {
    return this.loginService.isCustomer;
  }
}
