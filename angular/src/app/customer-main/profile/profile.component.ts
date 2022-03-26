import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit {
  isEditMode = false;
  username = 'HellBlizzard';
  constructor() {}

  ngOnInit(): void {}
  onSubmit() {}
  onSwitchEditMode() {
    this.isEditMode = !this.isEditMode;
  }
}
