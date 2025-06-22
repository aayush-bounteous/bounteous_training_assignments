import { Component, OnDestroy, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Store } from '@ngrx/store';
import { selectCart } from '../../store/selectors/book.selectors';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnDestroy {
  cartCount = 0;
  private subscription: Subscription;
  private store = inject(Store);
  private router = inject(Router);

  constructor() {
    this.subscription = this.store.select(selectCart).subscribe(cart => {
      this.cartCount = cart
        ? Object.values(cart).reduce((a: number, b: number) => a + b, 0)
        : 0;
    });
  }

  goToCart() {
    this.router.navigate(['/cart']);
  }

  goHome() {
    this.router.navigate(['/']);
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }
}
