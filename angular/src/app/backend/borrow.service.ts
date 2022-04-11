import { formatDate } from '@angular/common';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { MessageService } from 'primeng/api';
import { Subject } from 'rxjs';
import { Book } from '../util/data/book';
import { Borrow, BorrowStatus } from '../util/data/borrow';

const LINKBASE = 'http://localhost:8080/api/Borrow/';

@Injectable({
  providedIn: 'root',
})
export class BorrowService {
  borrows!: Borrow[];
  subject = new Subject<Borrow[]>();
  headers = new HttpHeaders().append('Content-Type', 'application/json');

  constructor(
    private http: HttpClient,
    private router: Router,
    private messageService: MessageService
  ) {}

  /**
   *
   * @param id Optional
   *
   * Without the id, the method will return the full list.
   */
  getBorrowByCustomerId(id?: number) {
    if (typeof id === 'number') {
      this.http
        .get(LINKBASE + 'getBorrowByUserId' + '?id=' + id)
        .subscribe((data) => {
          this.borrows = this.toBorrowList(data);
          this.subject.next(this.borrows);
        });
    } else {
      this.http.get(LINKBASE + 'getAllBorrows').subscribe((data) => {
        this.borrows = this.toBorrowList(data);
        this.subject.next(this.borrows);
      });
    }
  }

  toBorrowList(data: any): Borrow[] {
    let list: Borrow[] = [];
    data.forEach((borrow: Borrow) => {
      list.push(borrow);
    });
    return list;
  }

  requestBorrow(borrow: Borrow) {
    const formData = new FormData();
    formData.append('customerId', borrow.user.id + '');
    formData.append('password', borrow.book.id + '');
    this.http
      .post(
        LINKBASE + 'requestBook',
        JSON.stringify({
          customerId: borrow.user.id,
          bookId: borrow.book.id,
        }),
        { headers: this.headers }
      )
      .subscribe(
        (data) => {
          if (data.toString() == true + '')
            this.messageService.add({
              severity: 'success',
              summary: 'Successful',
              detail: 'Book Requested for Borrow',
              life: 1500,
            });
          else
            this.messageService.add({
              severity: 'error',
              summary: 'Failure',
              detail: 'Book Requested Already',
              life: 1500,
            });
        },
        (err) => {
          console.log(err);
        }
      );
  }
  rejectRequest(borrow: Borrow) {
    this.http
      .post(
        LINKBASE + 'rejectRequest',
        JSON.stringify({
          id: borrow.id,
        }),
        {
          headers: this.headers,
        }
      )
      .subscribe((data) => {
        console.log(data);
      });
  }
  acceptRequest(borrow: Borrow) {
    this.http
      .post(
        LINKBASE + 'acceptRequest',
        JSON.stringify({
          id: borrow.id,
        }),
        {
          headers: this.headers,
        }
      )
      .subscribe((data) => {
        console.log(data);
      });
  }

  isAvailable(book: Book) {
    this.http.get(LINKBASE + 'isAvailable' + '?bookId=' + book.id).subscribe(
      (data) => {
        return data;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  updateBorrow(borrow: Borrow) {
    this.http
      .post(LINKBASE + 'updateBorrow', JSON.stringify(borrow), {
        headers: this.headers,
      })
      .subscribe((data) => {
        console.log(data);
      });
  }
}
