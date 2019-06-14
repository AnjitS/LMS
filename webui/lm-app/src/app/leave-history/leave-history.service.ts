import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import 'rxjs/add/operator/toPromise';

import { Observable } from "rxjs/Observable";
  
import 'rxjs/add/operator/map';
import { Employee } from "../employee";
import { LeaveDetails } from '../leavedetails';



@Injectable()
export class LeaveHistoryService {
  empId:any = localStorage.getItem("employee.empId");

  constructor(private http:Http) { }
  LeaDetailsServ():Observable<LeaveDetails> {
    console.log("inside leave history service");
    console.log("emp id"+this.empId);

    return this.http.get('http://localhost:8080/ftp38/api/leavedetails/' + this.empId + '/history')
    .map(response => response.json() as LeaveDetails);
      
  }
}