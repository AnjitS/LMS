import { Component, OnInit } from '@angular/core';
import { MyDetailsService } from './my-details.service';
import { Employee } from '../employee';
@Component({
  selector: 'app-my-details',
  templateUrl: './my-details.component.html',
  styleUrls: ['./my-details.component.css'],
  providers: [ MyDetailsService ]
})
export class MyDetailsComponent implements OnInit {

  constructor(private mydetails: MyDetailsService) { }
  
  empId:string = localStorage.getItem('id');
  empdetails:Employee;
  
  ngOnInit() {
    console.log("My details:"+this.empId);
    this.mydetails.getEmpById(this.empId).then(empdetails=> this.empdetails=empdetails);  
  }
}
