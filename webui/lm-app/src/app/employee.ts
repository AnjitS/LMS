export class Employee {
    empId: number;
    empName: string;
    empEmailId: string;
    empMobNo: number;
    empDoj: string;
    empDept: string;
    empMgrId: number;
    empLeaveBalance: number;
      constructor(empId: number, empName: string, empEmailId: string,  empMobNo: number, empDoj: string, empDept: string ,empMgrId: number,
        empLeaveBalance: number) {
          this.empId = empId;
          this.empName = empName;
          this.empEmailId = empEmailId;
          this.empMobNo = empMobNo;
          this.empDoj = empDoj;
          this.empDept = empDept;
          this.empMgrId = empMgrId;
          this.empLeaveBalance = empLeaveBalance;

    }
}
