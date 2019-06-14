import { Component, OnInit } from '@angular/core';
import { LeaveHistoryService } from './leave-history.service';
import { Router } from '@angular/router';
import { LeaveDetails } from '../leavedetails';

@Component({
  selector: 'app-leave-history',
  templateUrl: './leave-history.component.html',
  styleUrls: ['./leave-history.component.css'],
  providers: [ LeaveHistoryService ]
})
export class LeaveHistoryComponent implements OnInit {

  constructor(private leahisser:LeaveHistoryService,private route:Router) { }

  ngOnInit() {
    this.leaHisDetails();
  }
  onSubmit(): void {
    console.log("click on button");
    this.route.navigate(["apply"]);
    
  }
  leaDetails: LeaveDetails;
  leaHisDetails():void {
    this.leahisser.LeaDetailsServ().subscribe(leaDetails => this.leaDetails = leaDetails);
    console.log(this.leaDetails);
  }
}