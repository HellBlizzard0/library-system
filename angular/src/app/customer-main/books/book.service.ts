import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  selectedBook = new Subject();
  constructor() {}
}
