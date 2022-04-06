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
  border = 'border-0';

  constructor(
    private loginService: LoginService,
    private userService: UserService
  ) {
    this.isEditMode = false;
  }

  ngOnChange() {}

  ngOnInit(): void {
    // this.loginService.userSubject.subscribe((data: User) => {
    //   this.user = data;
    // });
    this.user = this.loginService.user;
  }
  ngOnDestroy() {
    // this.loginService.userSubject.unsubscribe();
    this.user = {};
  }
  onSubmit() {
    this.loginService.userSubject.next(this.user);
    this.userService.updateUser(this.user);
    this.isEditMode = !this.isEditMode;
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
}
