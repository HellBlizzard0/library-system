import { Book } from './book';
import { User } from './user';

export interface Borrow {
  id: number;
  status?: BorrowStatus;
  book: Book;
  user: User;
  dateOfCreation: Date;
  lastUpdated: Date;
}

export interface BorrowStatus {
  id: number;
  status: string;
}
