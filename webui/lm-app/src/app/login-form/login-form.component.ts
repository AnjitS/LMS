import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
@Component({
  selector: 'app-login-form',
  templateUrl: './login-form.component.html',
  styleUrls: ['./login-form.component.css']
})
export class LoginFormComponent implements OnInit {

  ngOnInit(): void {
    throw new Error("Method not implemented.");
  }
  
  constructor(private router:Router) { }
  employee: Employee;

  onEnter(loginForm): void {
    localStorage.setItem('id', loginForm.value.empId);
    console.log(loginForm.value.empId);
      if(loginForm.value.empId == "1000") {
          console.log("welcome RAJA");
          this.router.navigate(["dashboard"]);
        } else if(loginForm.value.empId == "2000"){
          console.log("welcome RANI");
          this.router.navigate(["dashboard"]);
        } else if(loginForm.value.empId == "2001"){
          console.log("welcome RANA");
          this.router.navigate(["dashboard"]);
        } else if(loginForm.value.empId == "3000"){
          console.log("welcome POOJA GOPAL");
          this.router.navigate(["dashboard"]);
        } else if(loginForm.value.empId == "3001"){
          console.log("welcome AKASH SHARMA");
          this.router.navigate(["dashboard"]);
        } else if(loginForm.value.empId == "3002"){
          console.log("welcome  SAI SURYA VADDI");
          this.router.navigate(["dashboard"]);
        }else if(loginForm.value.empId == "3003"){
          console.log("welcome RASHMI RANAJAN DASH");
          this.router.navigate(["dashboard"]);
        }else if(loginForm.value.empId == "3004"){
          console.log("welcome ANJIT SOMANI");
          this.router.navigate(["dashboard"]);
        }else {
          console.log("wrong employee ID");
        }
    }
      onCancel() : void {
    this.router.navigate([""]); 
    }
}


