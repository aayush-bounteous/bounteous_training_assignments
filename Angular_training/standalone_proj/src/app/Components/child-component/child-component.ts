import { Component, Input, Output } from '@angular/core';
import { EventEmitter } from 'stream';

@Component({
  selector: 'app-child-component',
  imports: [],
  templateUrl: './child-component.html',
  styleUrl: './child-component.scss'
})
export class ChildComponent {
  ctitle:string="hi this is child compo"
  @Input() msgfromparent :string="";
  // @Output() msgforchild = new EventEmitter<any>();

  // NotifyMyParent(){
  //   this.msgforchild.emit("hello beta papa aaye hai");
  // }
}
