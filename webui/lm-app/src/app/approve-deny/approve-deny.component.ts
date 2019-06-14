import { Component, OnInit } from '@angular/core';
import { ApproveDenyService } from "./approve-deny.service";
import { LeaveDetails } from '../LeaveDetails';
import {RouterModule,Router,Routes} from '@angular/router';
import { Employee } from "../employee";


@Component({
  selector: 'app-approve-deny',
  templateUrl: './approve-deny.component.html',
  styleUrls: ['./approve-deny.component.css'],
})

export class ApproveDenyComponent implements OnInit {
  leaveData:LeaveDetails;
  empId2:any=localStorage.getItem("empId2");
  leaNoOfDays:any=localStorage.getItem("flag.levNoDays");
  startDate:any=localStorage.getItem("flag.levStartDate");
  endDate:any = localStorage.getItem("flag.levEndDate");
  leaveType:any = localStorage.getItem("flag.levType");
  leaveStatus:any=localStorage.getItem("flag.levStatus");
  leaveReason:any=localStorage.getItem("flag.levReason");
  constructor(private _approve : ApproveDenyService,private route:Router) { }
  
  obj = new LeaveDetails();

  details:Employee;
    empDetails():void{
      this._approve.fetch().then(details=>this.details=details);
      console.log(this.details);
    }
   
  ngOnInit() {
    this.empDetails();
    this._approve.listByIdAppDeny().then((leaveData)=>this.leaveData=leaveData);
    
  }
  
  onDeny(data:any):void {
    console.log("Deny");
    this.obj.empId=this.empId2;
    this.obj.levId=this.leaveData.levId;
    this.obj.levStatus=this.leaveData.levStatus="DENIED";
    this.obj.levMgrComments=data.levMgrComments;
      this._approve.approveOrDeny(this.obj).subscribe((leaveData)=>this.leaveData=leaveData);
      this.route.navigate(["dashboard"]);
  }

  Approve(data:any):void {
    console.log("Approved");
    this.obj.empId=this.empId2;
    this.obj.levId=this.leaveData.levId;
    this.obj.levStatus=this.leaveData.levStatus="APPROVED";
    this.obj.levMgrComments=data.levMgrComments;
      this._approve.approveOrDeny(this.obj).subscribe((leaveData)=>this.leaveData=leaveData);
      this.route.navigate(["dashboard"]);

  }

  onCancel(data:any):void {
    console.log("you will be moved to pending leaves");
    this.route.navigate(["leavepending"]);
  }

}