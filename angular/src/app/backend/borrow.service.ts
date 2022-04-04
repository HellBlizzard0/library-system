import { HttpClient, HttpHeaders } from '@angular/common/http';
import { ThisReceiver } from '@angular/compiler';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Book } from '../util/data/book';
import { Borrow } from '../util/data/borrow';

const LINKBASE = 'localost:8080:/api/Borrow/';

@Injectable({
  providedIn: 'root',
})
export class BorrowService {
  borrows!: Borrow[];
  subject = new Subject<Borrow[]>();

  constructor(private http: HttpClient, private router: Router) {}

  getBorrowByCustomerId(id: number) {
    this.borrows = BORROWS;

    this.subject.next(this.borrows);

    // let headers = new HttpHeaders();
    // headers.append('Content-Type', 'application/json');
    // headers.append('id', '902');
    // this.http
    //   .get(LINKBASE + 'getBorrowByIdOrUserIdOrBookId', { headers: headers })
    //   .subscribe((data) => {
    //     this.subject.next(borrows);
    //   });
  }

  toBorrowList(data: any) {}
}

const BOOKS: Book[] = [
  {
    id: 2,
    title: 'The Art of Super Mario Odyssey',
    dateOfCreation: new Date(),
    lastUpdated: new Date(),
    serialNumber: '9.78151E+12',
    authorName: 'Nintendo',
    description:
      "Take a globetrotting journey all over the world--and beyond!--with this companion art book to the hit video game for the Nintendo Switch(TM) system!\n\nIn October of 2017, Super Mario Odyssey(TM) took the gaming world by storm. Now, discover the art and expertise that went into creating one of Nintendo's best-loved games!\n\n This full-color volume clocks in at over 350 pages and features concept art, preliminary sketches, and notes from the development team, plus insight into some early ideas that didn't make it into the game itself! Explore the world of Super Mario Odyssey from every angle, including screen shots, marketing material, and more, to fully appreciate this captivating adventure",
    pageCount: 368,
    rating: 3.9,
    genres: 'Games &amp, Activities , Video &amp, Electronic',
  },
  {
    id: 4,
    title: 'The Painted Man (The Demon Cycle, Book 1)',
    dateOfCreation: new Date(),
    lastUpdated: new Date(),
    serialNumber: '9.78001E+12',
    authorName: 'Peter V. Brett',
    description:
      'The stunning debut fantasy novel from author Peter V. Brett.   The Painted Man, book one of the Demon Cycle, is a captivating and thrilling fantasy adventure, pulling the reader into a world of demons, darkness and heroes.  AS DARKNESS FALLS, THE DEMONS RISE For hundreds of years these creatures have terrorized the night, slowly culling the human population. It was not always this way. Men and women did not always cower behind protective magical wards and hope to see the dawn. Once, they battled the demons on equal terms, but those days, and skills, are gone. Arlen Bales lives with his parents on their isolated farmstead until a demon attack shatters their world. He learns a savage lesson that day: that people, as well as magic, can let you down. Rejecting the fear that kills as efficiently as the creatures, Arlen risks another path in order to offer humanity a last, fleeting chance of survival.',
    pageCount: 544,
    rating: 4.5,
    genres: 'Fiction , Fantasy , Dark Fantasy',
  },
];

const BORROWS: Borrow[] = [
  {
    id: 0,
    book: BOOKS[0],
    user: {
      id: 902,
      enabled: true,
      password: '123',
      username: 'bgd',
      dateOfCreation: new Date(),
      lastUpdated: new Date(),
      name: 'Ahmad',
      phoneNumber: '0522222222',
    },
    dateOfCreation: new Date(),
    lastUpdated: new Date(),
    status: {
      id: 1,
      status: 'borrowed',
    },
  },
];
