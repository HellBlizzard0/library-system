import { Component, HostListener, OnInit } from '@angular/core';

@Component({
  selector: 'app-librarian-main',
  templateUrl: './librarian-main.component.html',
  styleUrls: ['./librarian-main.component.css'],
})
export class LibrarianMainComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {
    this.getScreenWidth = window.innerWidth;
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
}
