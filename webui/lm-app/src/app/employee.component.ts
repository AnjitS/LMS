import { Component, OnInit } from '@angular/core';
import { EmployeeService } from './employee.service';
import { Employee } from './employee';
import { Router } from "@angular/router";

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./app.component.css'],
  providers: [ EmployeeService ]
})
export class EmployeeComponent implements OnInit {
  constructor(private employeeService: EmployeeService, private router: Router) { }

  title = 'Leave Management Application';
  employees: Employee[];
  getEmployees(): void {
      this.employeeService.getEmployees().then(employees => {
        console.log('getEmployees promise resolved : ' + employees.length);
        this.employees = employees;
      }
    );
  }
 
  onLogin(receive:any): void {
    // localStorage.setItem("",receive.empId);
    localStorage.setItem("employee.empId",receive.empId);
    localStorage.setItem("employee.empName",receive.empName);
    localStorage.setItem("employee.empLeaveBalance",receive.empLeaveBalance);
    localStorage.setItem('mgr', receive.empMgrId);
    this.router.navigate(["login"]);
  } 
  
  ngOnInit(): void {
    this.getEmployees();
  }
}
