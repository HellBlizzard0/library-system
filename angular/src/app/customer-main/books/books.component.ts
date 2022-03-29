import { Component, Input, OnInit } from '@angular/core';
import { Book, BookService } from '../../backend/book.service';
@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
})
export class BooksComponent implements OnInit {
  books: Book[] = [];

  constructor(private bookService: BookService) {
    this.bookService.fetchBooks();
  }

  ngOnInit(): void {
    this.bookService.booksList.subscribe((data: Book[]) => {
      this.books = data;
      console.log(this.books);
    });
  }

  getBooks() {
    return this.bookService.books;
  }
}
