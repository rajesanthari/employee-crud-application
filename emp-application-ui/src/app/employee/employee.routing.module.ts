import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { EmployeeAddEditDisplayComponent } from "./employee-add-edit-display/employee-add-edit-display.component";
import { EmployeeListComponent } from "./employee-list/employee-list.component";

const routes:Routes = [
      {path:'', component:EmployeeListComponent, pathMatch:'full'},
      {path:'add', component:EmployeeAddEditDisplayComponent, data:{isAdd:true}},
      {path:':id', component:EmployeeAddEditDisplayComponent, data:{isEdit:false}},
      {path:':id/edit', component:EmployeeAddEditDisplayComponent, data:{isEdit:true}}
]

@NgModule({
    imports:[RouterModule.forChild(routes)],
    exports:[RouterModule]
})
export class EmployeeRoutingModule {}