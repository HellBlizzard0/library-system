import { Book } from './book';
import { User } from './user';

export interface Borrow {
  id: number;
  status?: BorrowStatus;
  book: Book;
  user: User;
  dateOfCreation: Date | string;
  lastUpdate: Date | string;
}

export interface BorrowStatus {
  id: number;
  status: string;
}
