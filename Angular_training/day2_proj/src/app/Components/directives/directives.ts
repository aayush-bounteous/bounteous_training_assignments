import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-directives',
  imports: [CommonModule, Highlight],
  templateUrl: './directives.html',
  styleUrl: './directives.scss'
})
export class Directives {
  isVisible = true;
  textColor = 'blue';
  fontSize= '16px';
  isActive = true;
  items = ['Item 1','Item 2','Item 3','Item 4'];

  toggleVisibility(){
    this.isVisible= !this.isVisible;
  }


  changeStyle(){
    this.textColor=this.textColor=== 'blue' ? 'red' : 'blue';
    this.fontSize=this.fontSize=== 'blue' ? 'red' : 'blue';
  }

  toggleClass(){

  }

}
