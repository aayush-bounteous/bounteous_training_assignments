import { TestBed } from '@angular/core/testing';

import { ServiceTs } from './service.ts';
import { take } from 'rxjs';

describe('ServiceTs', () => {
  let service: ServiceTs;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ServiceTs);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
  it('should initialize with an empty task list',(done)=>{
    service.tasks$.pipe(take(1)).subscribe(tasks=>{
      expect(tasks.length).toBe(0);
      done();//callback func provided by jasmine, basically it tells the jasmine it is done 
    });
  });


  it('should add a new task',(done)=>{
    service.addTask('BUt milk');

    service.tasks$.pipe(take(1)).subscribe(tasks=>{
      expect(tasks.length).toBe(1);
      expect(tasks[0].title).toBe('Buy milk');
      expect(tasks[0].completed).toBeFalse();
      expect(tasks[0].id).toBeDefined();
      done;
    })

  });

   it('shloud toggle task completion status',(done)=>{
      service.addTask('learn angular');
      let taskId: number;
      service.tasks$.pipe(take(1)).subscribe(tasks => {
        taskId = tasks[0].id;
        service.toggleTask(taskId);
        service.tasks$.pipe(take(1)).subscribe(updatedTasks => {
          expect(updatedTasks[0].completed).toBeTrue();

          service.toggleTask(taskId);
          service.tasks$.pipe(take(1)).subscribe(finalTasks => {
            expect(finalTasks[0].completed).toBeFalse();
            done();
        });
      });
    });
  });


});
