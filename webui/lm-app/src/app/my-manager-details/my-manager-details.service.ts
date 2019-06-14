import { Injectable } from '@angular/core';
import { Observable } from  'rxjs/Rx';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Employee } from '../employee';

@Injectable()
export class MyManagerDetailsService {

  constructor(private http: Http) { }
  getMgrById(mgrId: string): Promise<Employee> { 
    console.log('getEmployees called on employee.service');
    return this.http.get('http://localhost:8080/ftp38/api/employees/'+ mgrId)
    .toPromise()
    .then(response => response.json() as Employee)
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }

}
