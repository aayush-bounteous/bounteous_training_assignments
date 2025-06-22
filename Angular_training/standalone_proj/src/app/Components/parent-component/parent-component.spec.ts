import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ParentComponent } from './parent-component';
import { By } from '@angular/platform-browser';
import { of } from 'rxjs';
import { FormsModule } from '@angular/forms';

import { ServiceTs } from '../../Services/service.ts';

describe('ParentComponent', () => {
  let component: ParentComponent;
  let fixture: ComponentFixture<ParentComponent>;
  let serviceSpy: jasmine.SpyObj<ServiceTs>;

  beforeEach(async () => {
    serviceSpy = jasmine.createSpyObj('ServiceTs', ['addTask'], {
      tasks$: of([]),
    });

     TestBed.configureTestingModule({
      // declarations: [ParentComponent],
      imports: [FormsModule],
      providers: [{ provide: ServiceTs, useValue: serviceSpy }]
    }).compileComponents();

    fixture = TestBed.createComponent(ParentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should trigger addTask method on button click', () => {
    const spy = spyOn(component, 'addTask');
    fixture.debugElement.query(By.css('button')).nativeElement.click();
    expect(spy).toHaveBeenCalled();
  });

  it('should calculate totals on init when tasks are empty', () => {
    expect(component.total).toBe(0);
    expect(component.completed).toBe(0);
    expect(component.pending).toBe(0);
  });

  it('should calculate totals correctly when tasks are present', () => {
    const tasks = [
      { title: 'Task 1', completed: true },
      { title: 'Task 2', completed: false },
      { title: 'Task 3', completed: true }
    ];

    // Replace observable with new tasks
    serviceSpy.tasks$ = of(tasks);
    component.ngOninit();
    fixture.detectChanges();

    expect(component.total).toBe(3);
    expect(component.completed).toBe(2);
    expect(component.pending).toBe(1);
  });

});
