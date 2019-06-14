import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { Observable } from  'rxjs/Rx';
import { ApplyLeave } from './applyleave';
@Injectable()
export class ApplyLeaveService {

  constructor(private http:Http) { }

  applyLeave(app:ApplyLeave): Promise<any> {
     console.log('APPLYLEAVE called on apply leave service');
     return this.http.post('http://localhost:8080/ftp38/api/employees/apply/',app)
     .toPromise()
     .then(response => response.json() as ApplyLeave)
     .catch(this.handleError);
  }

  private handleError(error: any): Promise<string> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}