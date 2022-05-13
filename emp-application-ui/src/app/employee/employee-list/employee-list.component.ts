import { Component, OnDestroy, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit,OnDestroy {
  employeeSubscription: Subscription = new Subscription();
  employeeList: Employee[] = [];
  constructor(private employeeService: EmployeeService, private router:Router, private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.refereshEmployeeList();
  }

  refereshEmployeeList() {
    this.employeeSubscription = this.employeeService.getAllEmployeList().subscribe( data => {
      this.employeeList = data;
    });
  }

  
  addEmployee() {
    this.router.navigate(['add'], {relativeTo:this.route} )
  }

  viewEmployee(id: number) {
    this.router.navigate([id], {relativeTo:this.route} )
  }

  editEmployee(id: number) {
    this.router.navigate([id,'edit'], {relativeTo:this.route} )
  }

  deleteEmployee(id: number) {
    
  }

  ngOnDestroy(): void {
    if ( !!this.employeeSubscription) {
      this.employeeSubscription.unsubscribe();
    }
  }

}
