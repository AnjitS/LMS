import { LeaveDetails } from '../leavedetails';

import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';
import 'rxjs/add/operator/map';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class LeaveDetailsService {
  
  constructor(private _http: Http) { }
  getLeaveDetails(): Promise<LeaveDetails[]> {
    console.log('getLeaveDetails called on leavedetails.service');
    return this._http.get('/ftp38/api/leavedetails')
    .toPromise()
    .then(response => response.json() as LeaveDetails[])
    .catch(this.handleError);
}
appDenyfun():Observable<LeaveDetails>{
  return this._http.get("http://localhost:8080/ftp38/api/leavedetails/2000/approveDeny")
  .map((response)=>response.json());
}
private handleError(error: any): Promise<any> {
  console.error('An error occurred', error); // for demo purposes only
  return Promise.reject(error.message || error);
}
}



