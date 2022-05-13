import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { EmployeeAddEditDisplayComponent } from './employee/employee-add-edit-display/employee-add-edit-display.component';
import { EmployeeListComponent } from './employee/employee-list/employee-list.component';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [
  {path:'', pathMatch:'full',redirectTo:'/employee'},
  {path:'employee', component:EmployeeComponent, children: [
    {path:'', component:EmployeeListComponent},
    {path:'add', component:EmployeeAddEditDisplayComponent, data:{isAdd:true}},
    {path:':id', component:EmployeeAddEditDisplayComponent, data:{isEdit:false}},
    {path:':id/edit', component:EmployeeAddEditDisplayComponent, data:{isEdit:true}}
    
  ]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
