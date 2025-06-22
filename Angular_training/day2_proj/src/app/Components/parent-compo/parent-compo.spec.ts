import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParentCompo } from './parent-compo';

describe('ParentCompo', () => {
  let component: ParentCompo;
  let fixture: ComponentFixture<ParentCompo>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParentCompo]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ParentCompo);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
