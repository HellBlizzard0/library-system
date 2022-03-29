import { Component, Input, OnInit } from '@angular/core';
import { PrimeNGConfig, SelectItem } from 'primeng/api';
import { Book, BookService } from '../../backend/book.service';
@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css'],
})
export class BooksComponent implements OnInit {
  books: Book[] = [];

  sortOptions!: SelectItem[];

  sortOrder!: number;

  sortField!: string;

  sortKey!: any;

  constructor(
    private bookService: BookService,
    private primengConfig: PrimeNGConfig
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
}
