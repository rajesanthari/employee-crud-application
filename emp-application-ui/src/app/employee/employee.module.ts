import { CommonModule } from "@angular/common";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { ReactiveFormsModule } from "@angular/forms";
import { EmployeeAddEditDisplayComponent } from "./employee-add-edit-display/employee-add-edit-display.component";
import { EmployeeListComponent } from "./employee-list/employee-list.component";
import { EmployeeRoutingModule } from "./employee.routing.module";

@NgModule({
    declarations:[
        EmployeeListComponent,
        EmployeeAddEditDisplayComponent
    ],
    imports: [
        CommonModule,
        HttpClientModule,
        ReactiveFormsModule,
        EmployeeRoutingModule
    ]
})
export class EmployeeModule {

}