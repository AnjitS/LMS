import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import { LeaveDetails } from '../leavedetails';

@Injectable()
export class LeavePendingService {

  handleError(arg0: any): any {
    throw new Error("Method not implemented.");
  }
  constructor(private _http:Http) { }
  
  empId:any = localStorage.getItem("employee.empId");
  levdeatailsFun(): Promise<LeaveDetails> {
      console.log('getEmployees called on employee.service');
      console.log('getEmployees called on employee.service'+this.empId);
      return this._http.get('http://localhost:8080/ftp38/api/leavedetails/'+this.empId+'/pendleav')
      .toPromise()
      .then(response => response.json() as LeaveDetails)
      .catch(this.handleError);
  }

}
