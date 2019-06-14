import { Component, OnInit } from '@angular/core';
import { Employee } from '../employee';
import { MyManagerDetailsService } from  './my-manager-details.service'
@Component({
  selector: 'app-my-manager-details',
  templateUrl: './my-manager-details.component.html',
  styleUrls: ['./my-manager-details.component.css'],
  providers: [ MyManagerDetailsService ]
})
export class MyManagerDetailsComponent implements OnInit {

  constructor(private mydetails: MyManagerDetailsService) { }
  mgrId:string = localStorage.getItem('mgr');
  mgrdetails: Employee;
  
  ngOnInit() {
    console.log("My manager id:");
    this.mydetails.getMgrById(this.mgrId).then(mgrdetails=> this.mgrdetails=mgrdetails);
  }

}
