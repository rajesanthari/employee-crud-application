import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './auth/home/home.component';
import { LogoutComponent } from './common/logout.component';
import { AutheGuardService } from './common/shared/auth.guard.service';
import { EmployeeComponent } from './employee/employee.component';

const routes: Routes = [ 
  {path:'', pathMatch:'full',redirectTo:'/auth'},
  {path:'login',loadChildren: () => import('./common/login/login.module').then(x => x.LoginModule)},
  {path:'logout',component:LogoutComponent},
  {path:'auth', component:HomeComponent, canActivate:[AutheGuardService], canActivateChild:[AutheGuardService] , children:[
    {path:'employee', component:EmployeeComponent, pathMatch:'prefix', loadChildren: () => import('./employee/employee.module').then(x => x.EmployeeModule) }
  ]},
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
