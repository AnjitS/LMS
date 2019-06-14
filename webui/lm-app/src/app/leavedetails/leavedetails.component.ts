import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router"; 
import { LeaveDetails } from '../leavedetails';
import { LeaveDetailsService } from './leavedetails.service';

@Component({
  selector: 'app-leavedetails',
  templateUrl: './leavedetails.component.html',
  styleUrls: ['./leavedetails.component.css']
})
export class LeavedetailsComponent implements OnInit {

  constructor(private leavedetailsService: LeaveDetailsService, private router: Router) { }

  title = 'Leave Management Application';
  leavedetails: LeaveDetails[];
  getLeaveDetails(): void {
    this.leavedetailsService.getLeaveDetails().then(leavedetails => {
      console.log('getLeaveDetails promise resolved : ' + leavedetails.length);
      this.leavedetails = leavedetails;
    }
  );
}

onLogin(): void {
    this.router.navigate(["login"]);
}


ngOnInit(): void {
  this.getLeaveDetails();
}

}
