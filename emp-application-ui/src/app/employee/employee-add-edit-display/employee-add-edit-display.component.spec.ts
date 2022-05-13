import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmployeeAddEditDisplayComponent } from './employee-add-edit-display.component';

describe('EmployeeAddEditDisplayComponent', () => {
  let component: EmployeeAddEditDisplayComponent;
  let fixture: ComponentFixture<EmployeeAddEditDisplayComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmployeeAddEditDisplayComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeAddEditDisplayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
