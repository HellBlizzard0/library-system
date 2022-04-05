import {
  HttpClient,
  HttpHeaderResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Book } from '../util/data/book';

const LINKBASE: string = 'http://localhost:8080/api/Book/';
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

  removeBooks(list: number[]) {
    list.forEach((id) => {
      let headers = new HttpHeaders();
      headers.append('id', id + '');

      this.http.get(LINKBASE + 'deleteBook' + '?id=' + id).subscribe((data) => {
        // console.log(data);
        this.fetchBooks();
      });
    });
  }

  updateBook(book: Book) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    };
    this.http
      .post(LINKBASE + 'updateBook', JSON.stringify(book), httpOptions)
      .subscribe((data) => {
        console.log(data);
      });
  }

  createBook(book: Book) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }),
    };
    // console.log(JSON.stringify(book));

    this.http
      .post(LINKBASE + 'addBook', JSON.stringify(book), httpOptions)
      .subscribe((data) => {
        console.log(data);
      });
  }

  toBooksList(data: any): Book[] {
    let books: Book[] = [];
    data.forEach((book: Book) => {
      books.push(book);
    });
    return books;
  }
  /**
   *
   * @param book
   * @returns FormData of the given object
   */
  toFormData(book: Book): FormData {
    const formData = new FormData();

    formData.append('id', (book.id as number) + '');
    formData.append('title', book.title as string);
    formData.append('dateOfCreation', (book.dateOfCreation as Date) + '');
    formData.append('lastUpdated', (book.lastUpdated as Date) + '');
    formData.append('authorName', book.authorName as string);
    formData.append('rating', (book.rating as number) + '');
    formData.append('description', book.description as string);
    formData.append('genres', book.genres as string);
    formData.append('pageCount', (book.pageCount as number) + '');
    formData.append('serialNumber', (book.serialNumber as string) + '');

    return formData;
  }
}
