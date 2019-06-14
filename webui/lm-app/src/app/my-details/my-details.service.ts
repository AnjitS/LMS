import { Injectable } from '@angular/core';
import { Observable } from  'rxjs/Rx';
import { Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { Employee } from '../employee';


@Injectable()
export class MyDetailsService {

  constructor(private http: Http) { }
  
  getEmpById(id: string): Promise<Employee> { 
    console.log('getEmployees called on employee.service');
    return this.http.get('http://localhost:8080/ftp38/api/employees/'+ id)
    .toPromise()
    .then(response => response.json() as Employee)
    .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    console.error('An error occurred', error); // for demo purposes only
    return Promise.reject(error.message || error);
  }
}
