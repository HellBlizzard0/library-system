import { Direction } from '@angular/cdk/bidi';
import { formatDate } from '@angular/common';
import { Component, OnInit, LOCALE_ID, Inject } from '@angular/core';
import { TranslateService } from '@ngx-translate/core';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
  SelectItem,
} from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { BorrowService } from 'src/app/util/services/borrow.service';
import { LoginService } from 'src/app/util/services/login.service';
import { I18nServiceService } from 'src/app/util/services/i18n-service.service';
import { Book } from 'src/app/util/data/book';
import { Borrow } from 'src/app/util/data/borrow';
import { BookService } from '../../util/services/book.service';
@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
})
export class BooksComponent implements OnInit {
  books: Book[] = [];
  bookEdit: Book = {};
  sortOptions!: SelectItem[];

  sortOrder!: number;
  selectedBooks: Book[] = [];
  sortField!: string;
  sortKey!: any;

  isEditMode = false;
  isAddNewMode = false;

  dir: Direction = 'ltr';

  constructor(
    @Inject(LOCALE_ID) public locale: string,
    private bookService: BookService,
    private primengConfig: PrimeNGConfig,
    private loginService: LoginService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private borrowService: BorrowService,
    private dialogService: DialogService,
    private i18nServiceService: I18nServiceService,
    private translate: TranslateService
  ) {
    this.bookService.fetchBooks();
  }

  ngOnInit(): void {
    this.i18nServiceService.dir.subscribe((dir) => {
      this.dir = dir;
    });
    this.bookService.booksList.subscribe((data: Book[]) => {
      this.books = data;
      // console.log(this.books);
    });

    this.sortOptions = [
      { label: 'Rating High to Low', value: '!rating' },
      { label: 'Rating Low to High', value: 'rating' },
    ];

    this.primengConfig.ripple = true;
  }
  showAddNewDialog() {
    this.bookEdit = {};
    this.bookEdit.rating = 0;
    this.isAddNewMode = true;
  }
  onSortChange(event: any) {
    let value = event.value;

    if (value.indexOf('!') === 0) {
      this.sortOrder = -1;
      this.sortField = value.substring(1, value.length);
    } else {
      this.sortOrder = 1;
      this.sortField = value;
    }
  }
  getBooks() {
    return this.bookService.books;
  }

  isCustomer(): boolean {
    return this.loginService.isCustomer;
  }

  enableEdit(book: Book) {
    this.bookEdit = book;
    this.isEditMode = true;
  }

  deleteSelected(value: number) {
    this.confirmationService.confirm({
      message: this.i18nServiceService.get('book.deleteDialog'),
      header: this.i18nServiceService.get('delete'),
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.bookService.removeBooks([value]);
        this.messageService.add({
          severity: 'success',
          summary: this.i18nServiceService.get('successful'),
          detail: this.i18nServiceService.get('success.bookDeleted'),
          life: 1500,
        });
      },
    });
  }
  confirmEdit(confirm: boolean) {
    if (confirm) {
      this.bookService.updateBook(this.bookEdit);
      this.bookEdit = {};
      this.isEditMode = false;
    } else {
      this.bookEdit = {};
      this.isEditMode = false;
    }
  }

  bookUnavailable() {
    this.messageService.add({
      severity: 'warn',
      summary: this.i18nServiceService.get('unavailable'),
      detail: this.i18nServiceService.get('success.bookUnavailable'),
      life: 1500,
    });
  }

  onSubmit() {
    this.bookService.createBook(this.bookEdit);
    this.messageService.add({
      severity: 'success',
      summary: this.i18nServiceService.get('successful'),
      detail: this.i18nServiceService.get('success.bookAdded'),
      life: 1500,
    });
    this.isAddNewMode = false;
  }

  requestBook(book: Book) {
    const borrow: Borrow = {
      id: 0,
      book: book,
      status: {},
      dateOfCreation: formatDate(new Date(), 'yyyy-MM-dd', this.locale),
      lastUpdate: formatDate(new Date(), 'yyyy-MM-dd', this.locale),
      user: this.loginService.getUser(),
    };
    this.borrowService.requestBorrow(borrow);

    this.messageService.add({
      severity: 'success',
      summary: this.i18nServiceService.get('successful'),
      detail: this.i18nServiceService.get('success.bookRequested'),
      life: 1500,
    });
  }

  printReport() {
    console.log();
    this.books[0].dateOfCreation?.getMilliseconds();

    this.bookService.printReport(this.selectedBooks);
  }
}
