import { ApplicationConfig, provideBrowserGlobalErrorListeners, provideZoneChangeDetection } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration, withEventReplay } from '@angular/platform-browser';

export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideZoneChangeDetection({ eventCoalescing: true }),
    provideRouter(routes), provideClientHydration(withEventReplay())
  ]
};


/*create an angular project with no basic skeleton design only
project: an ecommerce page which has till now only 5-6 products 
page 1 all these products must be visible with name and price in card style and on the navbar there must only cart and on cart there must comes number how many product is in it
page 2 when click on card on page 1 it must come here to page to like particular product page
there must comes name price and current stock, one button for add to cart, one button for +- selecting quantity after slecting cart must be updated 

give all the code from scratch from creating project to the last

first generate folder structure then i will ask you to start
 */