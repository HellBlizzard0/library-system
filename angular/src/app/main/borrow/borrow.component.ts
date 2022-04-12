import { Direction } from '@angular/cdk/bidi';
import { Component, OnInit } from '@angular/core';
import { BorrowService } from 'src/app/util/services/borrow.service';
import { LoginService } from 'src/app/util/services/login.service';
import { I18nServiceService } from 'src/app/util/services/i18n-service.service';
import { Borrow } from 'src/app/util/data/borrow';

@Component({
  selector: 'app-borrow',
  templateUrl: './borrow.component.html',
  styleUrls: ['./borrow.component.css'],
})
export class BorrowComponent implements OnInit {
  borrows: Borrow[] = [];
  status: string[] = ['OUTOFSTOCK', 'INSTOCK', 'LOWSTOCK'];
  dir!: Direction;

  constructor(
    private borrowService: BorrowService,
    private loginService: LoginService,
    private i18nServiceService: I18nServiceService
  ) {}

  ngOnInit(): void {
    this.i18nServiceService.dir.subscribe((dir: Direction) => {
      this.dir = dir;
    });
    this.borrowService.subject.subscribe((data: Borrow[]) => {
      this.borrows = data;
    });

    this.fetchData();
  }

  acceptRequest(borrow: Borrow) {
    this.borrowService.acceptRequest(borrow);
    this.fetchData();
  }

  rejectRequest(borrow: Borrow) {
    this.borrowService.rejectRequest(borrow);
    this.fetchData();
  }

  fetchData() {
    if (this.loginService.isCustomer)
      this.borrowService.getBorrowByCustomerId(
        this.loginService.user.id as number
      );
    else this.borrowService.getBorrowByCustomerId();

    this.borrows = this.borrowService.borrows;
  }

  displayAcceptReject(borrow: Borrow): boolean {
    return borrow.status?.id == 5 && !this.loginService.isCustomer;
  }

  displayCancelRequest(borrow: Borrow): boolean {
    return borrow.status?.id == 5 && this.loginService.isCustomer;
  }

  cancelRequest(borrow: Borrow) {
    this.borrowService.rejectRequest(borrow);
    this.fetchData();
  }

  displayReturn(borrow: Borrow): boolean {
    // console.log(borrow.status);

    if (
      borrow.status.id == 1 ||
      borrow.status.id == 3 ||
      borrow.status.id == 4
    ) {
      return true;
    } else return false;
  }

  isCustomer() {
    return this.loginService.isCustomer;
  }

  returnRequest(borrow: Borrow) {
    borrow.status = { id: 2, status: 'returned' };
    this.borrowService.updateBorrow(borrow);
  }
}
