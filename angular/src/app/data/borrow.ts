import { Book } from './book';
import { Customer } from './user';

export interface Borrow {
  id: number;
  status: BorrowStatus;
  book: Book;
  customer: Customer;
  dateOfCreation: Date;
  lastUpdated: Date;
}

export interface BorrowStatus {
  id: number;
  status: string;
}
