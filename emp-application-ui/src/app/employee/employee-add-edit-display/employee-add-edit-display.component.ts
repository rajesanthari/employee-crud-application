import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import {  Subscription } from 'rxjs';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-add-edit-display',
  templateUrl: './employee-add-edit-display.component.html',
  styleUrls: ['./employee-add-edit-display.component.css']
})
export class EmployeeAddEditDisplayComponent implements OnInit, OnDestroy {

  employeeForm: FormGroup = new FormGroup({});

  isEditAdd: boolean = false;
  isEdit: boolean = false;
  isAdd: boolean = false;

  employeeInfo: Employee;

  employeeSubscription: Subscription = new Subscription();

  constructor(private router: Router, private route: ActivatedRoute, private employeeService: EmployeeService, private formbuilder: FormBuilder) { }

  ngOnInit(): void {

    if (!!this.route.snapshot.data['isAdd']) {
      this.isAdd = true;
      this.isEditAdd = true;
      this.createEmployeeForm()
    } else {      
      this.isEdit = this.route.snapshot.data['isEdit'];
      this.refreshEmployeeInfo(this.route.snapshot.params['id']);
    }


  }

  refreshEmployeeInfo(id: number) {
    this.employeeService.getEmployeeById(id).subscribe(data => {
      this.employeeInfo = data;
      if (this.isEdit) {
        this.isEditAdd = true;
        this.createEmployeeForm(this.employeeInfo);
      }
    });
  }

  createEmployeeForm(employeeInfo?: Employee) {

    this.employeeForm = this.formbuilder.group({
      firstName: [employeeInfo?.firstName || '', [Validators.required, Validators.minLength(5)]],
      lastName: [employeeInfo?.lastName || '', [Validators.required, Validators.minLength(5)]],
      email: [employeeInfo?.email || '', [Validators.required, Validators.email]],
      mobile: [employeeInfo?.mobile || '', [Validators.required, Validators.minLength(10)]],
      salary: [employeeInfo?.salary || '', [Validators.required]]
    });

  }


  ngOnDestroy(): void {
    if (!!this.employeeSubscription) {
      this.employeeSubscription.unsubscribe();
    }
  }
  editEmployee(id: number) {
    this.router.navigate(['edit'], { relativeTo: this.route })
  }
  saveEmployee() {
    if ( this.isEdit ) {
      this.employeeService.updateEmployee(this.employeeInfo.id, this.employeeForm.value).subscribe( data => {
        alert("Employee details updated");
        this.redirectToEmployeeList();
      });
    } else {
      this.employeeService.newEmployee(this.employeeForm.value).subscribe(data => {
        alert("New employee added with id " +data.id);
        this.redirectToEmployeeList();
      });
    }
  }

  redirectToEmployeeList() {
    this.router.navigate(['auth','employee']);
  }

}
