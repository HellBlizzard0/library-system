import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

export interface Book {
  id:number;
  title:string;
  dateOfCreation:Date;
  lastUpdated:Date;
  serialNumber:string;
  authorName:string;
}
@Injectable({
  providedIn: 'root',
})
export class BookService {
  selectedBook = new Subject();
  books: Book[] = [{  id:0,
    title:'string',
    dateOfCreation:Date.prototype,
    lastUpdated:Date.prototype,
    serialNumber:'string',
    authorName:'string',}];
  constructor() {}
}
