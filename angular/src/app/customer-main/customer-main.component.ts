import { Component, OnInit, OnChanges, HostListener } from '@angular/core';

@Component({
  selector: 'app-customer-main',
  templateUrl: './customer-main.component.html',
  styleUrls: ['./customer-main.component.css'],
})
export class CustomerMainComponent implements OnInit {
  yourVisibleVaraible: any;
  baseZIndex = 2;
  mobile = false;
  maxWidth = 768;
  constructor() {}

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
  }

  public getScreenWidth: any;
  @HostListener('window:resize', ['$event'])
  onWindowResize() {
    this.getScreenWidth = window.innerWidth;
  }
}
