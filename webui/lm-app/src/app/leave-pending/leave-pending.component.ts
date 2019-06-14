import { Component, OnInit } from '@angular/core';
import { LeavePendingService } from './leave-pending.service';
import { LeaveDetails } from '../leavedetails';
import { Router } from '@angular/router';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-leave-pending',
  templateUrl: './leave-pending.component.html',
  styleUrls: ['./leave-pending.component.css']
})
export class LeavePendingComponent implements OnInit {

  
  employees: any;
  levdetails: any;
  msg:string;
  empId:any = localStorage.getItem("employee.empId");
  empName:any = localStorage.getItem("employee.empName");
  empLeaveBalance:any = localStorage.getItem("employee.empLeaveBalance");
  mgrId:any= localStorage.getItem('mgr');
  // mgrId2:any = localStorage.getItem("empId");

  public isDisabled:boolean=true;
  selectedRow : Number;
  setClickedRow : Function;
  setClickedRow2 : Function;
  flag :any;

  // data:string;
  levdata:LeaveDetails;
  constructor(private _levSerP : LeavePendingService,private router:Router,private employeeService:EmployeeService)  { }

  ngOnInit() {
    this.getLevPen();
    this.getempdet();
  }

  getLevPen() {
    this._levSerP.levdeatailsFun().then((levdata)=>this.levdata=levdata);
   
  this.setClickedRow = function(index,lea) {
  this.selectedRow2 = lea;
  this.selectedRow = index;
  console.log(this.selectedRow2);
  this.isDisabled=false;
  this.flag= lea;
   console.log(this.flag.levId);
   localStorage.setItem("flag.levId",lea.levId);
   localStorage.setItem("empId2",lea.empId);
   localStorage.setItem("flag.levStartDate",lea.levStartDate);
   localStorage.setItem("flag.levEndDate",lea.levEndDate);
   localStorage.setItem("flag.levType",lea.levType);
   localStorage.setItem("flag.levReason",lea.levReason);
   localStorage.setItem("flag.levStatus",lea.levStatus);
   localStorage.setItem("flag.levNoDays",lea.levNoOfDays);
  }
   }
  appDeny(){
 
    console.log(this.flag);
    console.log("My Reporting Employee's Pending Leave Applications Section");
    this.router.navigate(["appdeny"]);
    }
  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

  getempdet(){
    this.employeeService.getEmployees().then(employees => {
      console.log('getEmployees promise resolved : ' + employees.length);
      this.employees = employees;
      
    }
  );
  }
  
}