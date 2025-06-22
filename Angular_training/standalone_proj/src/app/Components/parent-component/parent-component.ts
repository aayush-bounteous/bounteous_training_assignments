import { Component, Input } from '@angular/core';
import { ChildComponent } from '../child-component/child-component';
import { FormsModule } from '@angular/forms';
import { ServiceTs } from '../../Services/service.ts';


@Component({
  selector: 'app-parent-component',
  imports: [FormsModule],
  templateUrl: './parent-component.html',
  styleUrl: './parent-component.scss'
})
export class ParentComponent {

  tasks: any[]=[];

  constructor(private  taskService:ServiceTs){

  }

ngOninit(){
  this.taskService.tasks$.subscribe(t=>{this.tasks=t
    console.log(this.tasks);
  });
}


total=0;
completed=0;
pending=0;


taskInput: string="";
// addTask(title:string){
//   console.log(title);
//   if(this.taskInput.trim()){
//     this.taskService.addTask(this.taskInput)
//   }
// }
addtask(){
  if(this.taskInput.trim()){
this.taskService=this.addTask(this.taskInput.trim());
this.taskInput="";
  }
}
  addTask(arg0: string): ServiceTs {
    throw new Error('Method not implemented.');
  }


}
