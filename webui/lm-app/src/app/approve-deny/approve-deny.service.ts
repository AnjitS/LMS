import { Injectable } from '@angular/core';
import { Http,Response } from "@angular/http";
import { Observable } from "rxjs/Rx";
import { LeaveDetails } from '../LeaveDetails';
import 'rxjs/add/operator/map';
import { Employee } from '../employee';

@Injectable()
export class ApproveDenyService {

    // empID:any=localStorage.getItem("empId");
    empID2:any=localStorage.getItem("empId2");
    levID:any=localStorage.getItem("flag.levId");
    constructor(private _http:Http) { }
      listByIdAppDeny(): Promise<LeaveDetails> {
        console.log('getleaves called on leave.service');
        console.log(this.levID);
        return this._http.get('http://localhost:8080/ftp38/api/leavedetails/'+this.levID+'/levId')
        .toPromise()
        .then(response => response.json() as LeaveDetails)
        .catch(this.handleError);
    }

    approveOrDeny(data:any): Observable<LeaveDetails> {
      console.log(this.empID2);
      console.log('inside approve deny service');
      return this._http.post('http://localhost:8080/ftp38/api/leavedetails/'+this.empID2+'/approveDeny',data)
      .map(response => response.json() as LeaveDetails);
  }
  

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
    fetch():Promise<Employee>{
        console.log("inside mydetails service");
        console.log(this.empID2);
        return this._http.get("http://localhost:8080/ftp38/api/employees/" + this.empID2)
        .toPromise()
        .then(response=>response.json() as Employee).catch(this.handleError);
      }

}
