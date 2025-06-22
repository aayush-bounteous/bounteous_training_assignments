import { ViewEncapsulation } from '@angular/core';
import { Component } from '@angular/core';

@Component({
  selector: 'app-child-compo',
  imports: [],
  standalone: true,
  templateUrl: './child-compo.html',
  styleUrl: './child-compo.scss',
  encapsulation : ViewEncapsulation.ShadowDom
})
export class ChildCompo {

}
