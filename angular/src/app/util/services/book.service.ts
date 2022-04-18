import {
  HttpClient,
  HttpHeaderResponse,
  HttpHeaders,
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Book } from '../data/book';
import { BorrowService } from './borrow.service';
import { I18nServiceService } from './i18n-service.service';
import { saveAs } from 'file-saver';

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
      lastUpdate: new Date(),
      serialNumber: 'string',
      authorName: 'string',
    },
  ];

  constructor(
    private http: HttpClient,
    private borrowService: BorrowService,
    private i18nServiceService: I18nServiceService
  ) {}

  fetchBooks() {
    this.http.get(LINKBASE + 'getAllBooksWithAvailablity').subscribe((data) => {
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
        this.fetchBooks();
      });
  }

  toBooksList(data: any): Book[] {
    let books: Book[] = [];
    data.forEach((element: any) => {
      // book.available = this.borrowService.isAvailable(book);
      books.push({
        id: element.book.id,
        title: element.book.title,
        dateOfCreation: element.book.dateOfCreation,
        lastUpdate: element.book.lastUpdate,
        serialNumber: element.book.serialNumber,
        authorName: element.book.authorName,
        description: element.book.description,
        pageCount: element.book.pageCount,
        rating: element.book.rating,
        genres: element.book.genres,
        available: element.available,
      });
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
    formData.append('lastUpdate', (book.lastUpdate as Date) + '');
    formData.append('authorName', book.authorName as string);
    formData.append('rating', (book.rating as number) + '');
    formData.append('description', book.description as string);
    formData.append('genres', book.genres as string);
    formData.append('pageCount', (book.pageCount as number) + '');
    formData.append('serialNumber', (book.serialNumber as string) + '');

    return formData;
  }

  printReport(books: Book[]) {
    // const httpOptions = ;
    console.log(
      JSON.stringify({
        bookList: books,
      })
    );

    this.http
      .post(
        'http://localhost:8080/api/Report/print/' +
          (this.i18nServiceService.isEnglish() ? 'en' : 'ar'),
        JSON.stringify({
          bookList: books,
        }),
        {
          headers: new HttpHeaders({
            'Content-Type': 'application/json',
          }),
          responseType: 'blob',
        }
      )
      .subscribe(
        (blob: Blob) => {
          // saveAs(blob, 'report.pdf');
          let url = window.URL.createObjectURL(blob);
          let a = document.createElement('a');
          document.body.appendChild(a);
          a.setAttribute('style', 'display: none');
          a.href = url;
          a.download =
            'Books Report (' +
            (this.i18nServiceService.isEnglish() ? 'en' : 'ar') +
            ').pdf';
          a.click();
          window.URL.revokeObjectURL(url);
          a.remove();
        },
        (e) => {
          console.log(e);
        }
      );
  }
}
