import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { selectCartItems, selectCartTotal } from '../../store/selectors/book.selectors';
import { increaseQty, decreaseQty, removeFromCart, checkout } from '../../store/actions/book.actions';
import { CommonModule } from '@angular/common';
import { AppState } from '../../store/state'; // Fix path if needed

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.scss']
})
export class CartComponent {
  items: any[] = [];
  total = 0;
  showSuccess = false;

  constructor(private store: Store<{ app: AppState }>) {
    this.store.select(selectCartItems).subscribe(items => this.items = items);
    this.store.select(selectCartTotal).subscribe(total => this.total = total);
  }

  increase(bookId: string) {
    this.store.dispatch(increaseQty({ bookId }));
  }

  decrease(bookId: string) {
    this.store.dispatch(decreaseQty({ bookId }));
  }

  remove(bookId: string) {
    this.store.dispatch(removeFromCart({ bookId }));
  }

  onCheckout() {
    this.store.dispatch(checkout());
    this.showSuccess = true;
    setTimeout(() => this.showSuccess = false, 3000);
  }
}
