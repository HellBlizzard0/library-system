import { Component, OnInit } from '@angular/core';
import { BorrowService } from 'src/app/backend/borrow.service';
import { Borrow } from 'src/app/util/data/borrow';

@Component({
  selector: 'app-borrow',
  templateUrl: './borrow.component.html',
  styleUrls: ['./borrow.component.css'],
})
export class BorrowComponent implements OnInit {
  borrows: Borrow[] = [];
  status: string[] = ['OUTOFSTOCK', 'INSTOCK', 'LOWSTOCK'];

  constructor(private borrowService: BorrowService) {}

  ngOnInit(): void {
    this.borrowService.subject.subscribe((data: Borrow[]) => {
      this.borrows = data;
    });

    this.borrowService.getBorrowByCustomerId(-1);
  }
}
