import { Injectable } from '@angular/core';
import { title } from 'process';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ServiceTs {

  private taskSubject = new BehaviorSubject<any[]>([]);
  tasks$ = this.taskSubject.asObservable();
  constructor() { }
  addTask(taskInput: string){
    console.log(title);
    const newTask:any={
    id:Date.now,
    title,
    completed:false

    };

    const updated =[...this.taskSubject.getValue(),newTask];
    console.log(updated);
    this.taskSubject.next(updated);
  }

  toggleTask(id:number){

  }
}
