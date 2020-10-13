import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeavedetailsComponent } from './leavedetails.component';

describe('LeavedetailsComponent', () => {
  let component: LeavedetailsComponent;
  let fixture: ComponentFixture<LeavedetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeavedetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeavedetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});