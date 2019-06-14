import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApplyLeave } from './applyleave';
import { ApplyLeaveService } from './apply-leave.service';
@Component({
  selector: 'app-apply-leave',
  templateUrl: './apply-leave.component.html',
  styleUrls: ['./apply-leave.component.css']
})
export class ApplyLeaveComponent implements OnInit {
  
  constructor(private router: Router, private app: ApplyLeaveService) { }
  ld= new ApplyLeave();
  msg: string;
  empId = localStorage.getItem('id');
  onApply(apply): void {
    console.log("inside apply component1");
    this.ld.empId = apply.empId;
    this.ld.levStartDate = apply.levStartDate;
    this.ld.levEndDate = apply.levEndDate;
    this.ld.levAppliedOn = apply.levAppliedOn;
    this.ld.levNoOfDays = apply.levNoOfDays;
    this.ld.levType = apply.levType;
    this.ld.levReason = apply.levReason;
    if(this.ld.empId == 1000) {
      this.ld.levStatus=apply.levStatus="APPROVE";
    } else {
      this.ld.levStatus=apply.levStatus="PENDING";
    }
    console.log(this.ld);
    this.app.applyLeave(this.ld).then((data)=>this.msg=data);
    this.router.navigate(["dashboard"]);
   }

  onCancel(): void {
    this.router.navigate(["dashboard"]);
   }

  ngOnInit() {
  }

}