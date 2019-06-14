import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MyManagerDetailsComponent } from './my-manager-details.component';

describe('MyManagerDetailsComponent', () => {
  let component: MyManagerDetailsComponent;
  let fixture: ComponentFixture<MyManagerDetailsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MyManagerDetailsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MyManagerDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
