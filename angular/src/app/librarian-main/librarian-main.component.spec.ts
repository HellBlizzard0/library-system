import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LibrarianMainComponent } from './librarian-main.component';

describe('LibrarianMainComponent', () => {
  let component: LibrarianMainComponent;
  let fixture: ComponentFixture<LibrarianMainComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LibrarianMainComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LibrarianMainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
