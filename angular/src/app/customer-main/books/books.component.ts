import { Component, Input, OnInit } from '@angular/core';
import { BookService } from './book.service';
@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  constructor(private bookService: BookService) { }

  ngOnInit(): void {
    console.log(this.bookService.books);
  }

}
