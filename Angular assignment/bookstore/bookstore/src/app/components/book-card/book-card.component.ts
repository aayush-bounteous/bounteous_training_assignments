import { Component, Input } from '@angular/core';
import { Store } from '@ngrx/store';
import { addToCart } from '../../store/actions/book.actions';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-book-card',
  templateUrl: './book-card.component.html',
  styleUrls: ['./book-card.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class BookCardComponent {
  @Input() book: any;
  @Input() inCart = 0;

  showModal = false;

  constructor(private store: Store) {}

  openModal() {
    if (this.book.qty > 0) {
      this.showModal = true;
    }
  }

  closeModal() {
    this.showModal = false;
  }

  addBook(event?: Event) {
    if (event) event.stopPropagation(); // prevent card click
    if (this.book.qty > 0 && this.inCart < 2) {
      this.store.dispatch(addToCart({ bookId: this.book.id }));
    }
  }
}


