import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  isDisabled:boolean=false;
  constructor(private router: Router) { }

  ngOnInit() {
  }

  applyLeave(): void {
    this.router.navigate(["apply"]);
  }
  pending(){
    this.router.navigate(["leavepending"]);
  }
  myDetSection(){
    this.router.navigate(["MyDetails"]);
  }
  myManSection(){
    this.router.navigate(["ManagerDetails"]);
  }
}
