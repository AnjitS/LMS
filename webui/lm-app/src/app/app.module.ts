import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginFormComponent } from './login-form/login-form.component';
import { EmployeeComponent } from './employee.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { FormsModule } from '@angular/forms';
import { LeavePendingComponent } from './leave-pending/leave-pending.component';
import { LeavePendingService } from './leave-pending/leave-pending.service';

import { ApproveDenyComponent } from './approve-deny/approve-deny.component';
import { LeavedetailsComponent } from './leavedetails/leavedetails.component';
import { ApproveDenyService } from './approve-deny/approve-deny.service';
import { ApplyLeaveComponent } from './apply-leave/apply-leave.component';
import { ApplyLeaveService } from './apply-leave/apply-leave.service';
import { MyDetailsComponent } from './my-details/my-details.component';
import { MyManagerDetailsComponent } from './my-manager-details/my-manager-details.component';
import { MyDetailsService } from './my-details/my-details.service';
import { MyManagerDetailsService } from './my-manager-details/my-manager-details.service';
import { LeaveHistoryComponent } from './leave-history/leave-history.component';
import { LeaveHistoryService } from './leave-history/leave-history.service';


const appRoute: Routes = [
  {path: "", component: EmployeeComponent},
  {path: "login", component: LoginFormComponent},
  {path: "dashboard", component: DashboardComponent},
  {path: "leavepending", component: LeavePendingComponent},
  {path: "apply", component: ApplyLeaveComponent},
  {path: "MyDetails", component: MyDetailsComponent},
  {path: "ManagerDetails", component: MyManagerDetailsComponent},
  {path:"leave",component :LeavedetailsComponent},
  {path:"appdeny",component:ApproveDenyComponent},
  {path: "leavehistory", component: LeaveHistoryComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    LoginFormComponent,
    DashboardComponent,
    EmployeeComponent,
    LeavePendingComponent,
    ApproveDenyComponent,
    LeavedetailsComponent,
    ApplyLeaveComponent,
    MyDetailsComponent,
    MyManagerDetailsComponent,
    LeaveHistoryComponent
  ],

  imports: [
    BrowserModule,
    HttpModule,
    RouterModule,
    FormsModule,
    RouterModule.forRoot(appRoute)
  ],
  providers: [LeavePendingService,ApplyLeaveService, MyDetailsService, MyManagerDetailsService,ApproveDenyService,LeaveHistoryService],
  bootstrap: [AppComponent]
})
export class AppModule { }
