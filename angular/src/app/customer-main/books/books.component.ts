import { Component, Input, OnInit } from '@angular/core';
import { Book, BookService } from './book.service';
@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
})
export class BooksComponent implements OnInit {
  books: Book[];
  constructor(private bookService: BookService) {
    this.books = this.getBooks();
  }

  ngOnInit(): void {
    console.log(this.books);
  }

  getBooks() {
    return this.bookService.books;
  }
}
