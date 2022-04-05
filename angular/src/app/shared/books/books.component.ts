import { Component, Input, OnInit } from '@angular/core';
import {
  ConfirmationService,
  MessageService,
  PrimeNGConfig,
  SelectItem,
} from 'primeng/api';
import { LoginService } from 'src/app/backend/login.service';
import { Book } from 'src/app/util/data/book';
import { BookService } from '../../backend/book.service';
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

  constructor(
    private bookService: BookService,
    private primengConfig: PrimeNGConfig,
    private loginService: LoginService,
    private messageService: MessageService,
    private confirmationService: ConfirmationService
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
}

// import { Component, Input, OnInit } from '@angular/core';
// import {
//   ConfirmationService,
//   MessageService,
//   PrimeNGConfig,
//   SelectItem,
// } from 'primeng/api';
// import { Book } from 'src/app/data/book';
// import { BookService } from '../../backend/book.service';
// @Component({
//   selector: 'app-books',
//   templateUrl: './books.component.html',
//   styleUrls: ['./books.component.css'],
// })
// export class BooksComponent implements OnInit {
//   books: Book[] = [];
//   book!: Book;

//   sortOptions!: SelectItem[];
//   sortOrder!: number;
//   sortField!: string;
//   sortKey!: any;

//   bookDialog: boolean = false;
//   selectedBooks: Book[] = [];

//   submitted!: boolean;

//   constructor(
//     private bookService: BookService,
//     private primengConfig: PrimeNGConfig,
//     private messageService: MessageService,
//     private confirmationService: ConfirmationService
//   ) {
//     this.bookService.fetchBooks();
//   }

//   ngOnInit(): void {
//     this.bookService.booksList.subscribe((data: Book[]) => {
//       this.books = data;
//       console.log(this.books);
//     });

//     this.sortOptions = [
//       { label: 'Rating High to Low', value: '!rating' },
//       { label: 'Rating Low to High', value: 'rating' },
//     ];

//     this.primengConfig.ripple = true;
//   }
//   onSortChange(event: any) {
//     let value = event.value;

//     if (value.indexOf('!') === 0) {
//       this.sortOrder = -1;
//       this.sortField = value.substring(1, value.length);
//     } else {
//       this.sortOrder = 1;
//       this.sortField = value;
//     }
//   }
//   getBooks() {
//     return this.bookService.books;
//   }

//   saveBook() {
//     this.submitted = true;

//     if (this.book.title != '') {
//       if (this.book.id) {
//         this.books[this.findIndexById(this.book.id)] = this.book;
//         this.messageService.add({
//           severity: 'success',
//           summary: 'Successful',
//           detail: 'Product Updated',
//           life: 3000,
//         });
//       } else {
//         this.book.id = this.createId();
//         // this.book.image = 'book-placeholder.svg';
//         this.books.push(this.book);
//         this.messageService.add({
//           severity: 'success',
//           summary: 'Successful',
//           detail: 'Book Created',
//           life: 3000,
//         });
//       }

//       this.books = [...this.books];
//       this.bookDialog = false;
//       this.book = {};
//     }
//   }
//   createId(): number {
//     let id = 0;
//     // var chars =
//     //   'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
//     // for (var i = 0; i < 5; i++) {
//     //   id += chars.charAt(Math.floor(Math.random() * chars.length));
//     // }
//     return id;
//   }

//   findIndexById(id: number): number {
//     let index = -1;
//     for (let i = 0; i < this.books.length; i++) {
//       if (this.books[i].id === id) {
//         index = i;
//         break;
//       }
//     }

//     return index;
//   }

//   hideDialog() {
//     this.bookDialog = false;
//     this.submitted = false;
//   }
//   editBook(book: Book) {
//     this.book = { ...book };
//     this.bookDialog = true;
//   }

//   deleteBook(book: Book) {
//     this.confirmationService.confirm({
//       message: 'Are you sure you want to delete ' + book.title + '?',
//       header: 'Confirm',
//       icon: 'pi pi-exclamation-triangle',
//       accept: () => {
//         // this.books = this.book.filter((val) => val.id !== book.id);
//         this.book = {};
//         this.messageService.add({
//           severity: 'success',
//           summary: 'Successful',
//           detail: 'Product Deleted',
//           life: 3000,
//         });
//       },
//     });
//   }

//   deleteSelectedBooks() {}
//   openNew() {
//     this.book = {};
//     this.submitted = false;
//     this.bookDialog = true;
//   }
// }
