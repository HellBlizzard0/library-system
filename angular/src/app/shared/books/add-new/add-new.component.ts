import { Component, OnInit } from '@angular/core';
import { BookService } from 'src/app/backend/book.service';
import { Book } from 'src/app/util/data/book';

@Component({
  selector: 'app-add-new',
  templateUrl: './add-new.component.html',
  styleUrls: ['./add-new.component.css'],
})
export class AddNewComponent implements OnInit {
  book: Book = {};

  constructor(private bookService: BookService) {}

  ngOnInit(): void {
    this.book.rating = 0;
  }

  onSubmit() {
    this.bookService.createBook(this.book);
    this.ref.destroy();
  }
}
