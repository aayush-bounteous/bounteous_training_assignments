import { Component, ViewEncapsulation } from '@angular/core';
import { ChildCompo } from '../child-compo/child-compo';

@Component({
  selector: 'app-parent-compo',
  standalone: true,
  imports: [ChildCompo],
  templateUrl: './parent-compo.html',
  styleUrl: './parent-compo.scss',
  encapsulation:ViewEncapsulation.ShadowDom
})
export class ParentCompo {

}
