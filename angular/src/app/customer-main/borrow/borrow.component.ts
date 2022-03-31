import { Component, OnInit } from '@angular/core';
import { BorrowService } from 'src/app/backend/borrow.service';
import { Borrow } from 'src/app/data/borrow';

@Component({
  selector: 'app-borrow',
  templateUrl: './borrow.component.html',
  styleUrls: ['./borrow.component.css'],
})
export class BorrowComponent implements OnInit {
  borrows: Borrow[] = [];

  constructor(private borrowService: BorrowService) {
    this.borrowService.getBorrowByCustomerId(-1);
  }

  ngOnInit(): void {
    this.borrowService.subject.subscribe((data: Borrow[]) => {
      this.borrows = data;
      console.log(this.borrows);
    });
  }
}
