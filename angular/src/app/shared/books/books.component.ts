import { Component, Input, OnInit } from '@angular/core';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
  SelectItem,
} from 'primeng/api';
import { DialogService } from 'primeng/dynamicdialog';
import { LoginService } from 'src/app/backend/login.service';
import { Book } from 'src/app/util/data/book';
import { BookService } from '../../backend/book.service';
import { AddNewComponent } from './add-new/add-new.component';
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
  constructor(
    private bookService: BookService,
    private primengConfig: PrimeNGConfig,
    private loginService: LoginService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService,
    private dialogService: DialogService
  ) {
    this.bookService.fetchBooks();
  }

  ngOnInit(): void {
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
      message: 'Are you sure you want to delete the selected Book?',
      header: 'Confirm',
      icon: 'pi pi-exclamation-triangle',
      accept: () => {
        this.bookService.removeBooks([value]);
        this.messageService.add({
          severity: 'success',
          summary: 'Successful',
          detail: 'Book Deleted',
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

  onSubmit() {
    this.bookService.createBook(this.bookEdit);
    this.messageService.add({
      severity: 'success',
      summary: 'Successful',
      detail: 'Book Added',
      life: 2000,
    });
    this.isAddNewMode = false;
  }
}
