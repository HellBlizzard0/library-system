import { HttpClient, HttpHeaderResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
const LINKBASE: string = 'http://localhost:8080/api/Book/';

export interface Book {
  id: number;
  title: string;
  dateOfCreation: Date;
  lastUpdated: Date;
  serialNumber: string;
  authorName: string;
  rating?: number;
  description?: string;
  genres?: string;
  pageCount?: number;
}
@Injectable({
  providedIn: 'root',
})
export class BookService {
  selectedBook = new Subject();
  booksList = new Subject<Book[]>();
  books: Book[] = [
    {
      id: 0,
      title: 'Book Awesome Title 123',
      dateOfCreation: new Date(),
      lastUpdated: new Date(),
      serialNumber: 'string',
      authorName: 'string',
    },
  ];

  constructor(private http: HttpClient) {}

  fetchBooks() {
    this.http.get(LINKBASE + 'getAllBooks').subscribe((data) => {
      this.booksList.next(this.toBooksList(data));
    });
  }

  removeBooks() {
    console.log(this.removeBooks.name + ': Unimplemented');
  }

  updateBook() {
    console.log(this.updateBook.name + ': Unimplemented');
  }

  createBook() {
    console.log(this.createBook.name + ': Unimplemented');
  }

  toBooksList(data: any): Book[] {
    let books: Book[] = [];
    data.forEach((book: Book) => {
      books.push(book);
    });
    return books;
  }
}
