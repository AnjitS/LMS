package com.hexaware.ftp38.model;

import com.hexaware.ftp38.persistence.DbConnection;
import com.hexaware.ftp38.persistence.EmployeeDAO;

import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Employee class to store employee personal details.
 * @author hexware
 */
public class Employee {

  /**
   * empId to store employee id.
   * empName to store employee name.
   * empEmailId to store employee email id.
   * empMobNo to store employee mobile number.
   * empDoj to store employee date of joining.
   * empDept to store the employees department.
   * empMgrId to store the manager id.
   * empLeaveBalance to store the number of leaves left.
   */
  private int empId;
  private String empName;
  private String empEmailId;
  private long empMobNo;
  private Date empDoj;
  private String empDept;
  private int empMgrId;
  private int empLeaveBalance;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Employee emp = (Employee) obj;
    if (Objects.equals(empId, emp.empId) && Objects.equals(empName, emp.empName)
        && Objects.equals(empEmailId, emp.empEmailId) && Objects.equals(empMobNo, emp.empMobNo)
        && Objects.equals(empDoj, emp.empDoj) && Objects.equals(empDept, emp.empDept)
        && Objects.equals(empMgrId, emp.empMgrId) && Objects.equals(empLeaveBalance, emp.empLeaveBalance)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, empName, empEmailId, empMobNo, empDoj, empDept, empMgrId, empLeaveBalance);
  }

  /**
   * @param argEmpId to initialize employee id.
   */
  public Employee(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * default constructor.
   */
  public Employee() { }
  @Override
  public final String toString() {
    return "EmpId : " +  this.empId + "  " + "empName: " + this.empName + "  " + "empEmailId: " + this.empEmailId
      + "  " + "empMobNo: " + this.empMobNo + "  " + "empDoj: " + this.empDoj + "  " + "empDept: " + this.empDept
      + "  " + "empMgrId: " +  this.empMgrId + "  " + "empLeaveBalance: " + this.empLeaveBalance;
  }
 /**
  * @param argEmpId to initialize employee id.
  * @param argEmpName to initialize employee name.
  * @param argEmpEmailId to initialize employee EmailId.
  * @param argEmpMobNo to initialize employee mobile number.
  * @param argEmpDoj to initialize employee Date of joining.
  * @param argEmpDept to initialize employee department.
  * @param argEmpMgrId to initialize employee manager id.
  * @param argEmpLeaveBalance to initialize employee number of leaves left.
  */
  public Employee(final int argEmpId, final String argEmpName, final String argEmpEmailId, final long argEmpMobNo,
      final Date argEmpDoj, final String argEmpDept, final int argEmpMgrId, final int argEmpLeaveBalance) {
    this.empId = argEmpId;
    this.empName = argEmpName;
    this.empEmailId = argEmpEmailId;
    this.empMobNo = argEmpMobNo;
    this.empDoj = argEmpDoj;
    this.empDept = argEmpDept;
    this.empMgrId = argEmpMgrId;
    this.empLeaveBalance = argEmpLeaveBalance;
  }
  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the EmployeeName.
   * @return this Employee's Name.
   */
  public final String getEmpName() {
    return empName;
  }
  /**
   * Gets the EmployeeEmailId.
   * @return this Employee's EmailId.
   */
  public final String getEmpEmailId() {
    return empEmailId;
  }
  /**
   * Gets the EmployeeMobNo.
   * @return this Employee's MobNo.
   */
  public final long getEmpMobNo() {
    return empMobNo;
  }
  /**
   * Gets the EmployeeDoj.
   * @return this Employee's Doj.
   */
  public final Date getEmpDoj() {
    return empDoj;
  }
  /**
   * Gets the EmployeeDept.
   * @return this Employee's Dept.
   */
  public final String getEmpDept() {
    return empDept;
  }
  /**
  * Gets the EmployeeMgrId.
  * @return this Employee's MgrId.
  */
  public final int getEmpMgrId() {
    return empMgrId;
  }
  /**
   * Gets the EmployeeLeavesBalance.
   * @return this Employee's LeavesBalance.
   */
  public final int getEmpLeaveBalance() {
    return empLeaveBalance;
  }
  /**
   *
   * @param argEmpId to set employee id.
   */
  public final void setEmpId(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   *
   * @param argEmpName to set employee name.
   */
  public final void setEmpName(final String argEmpName) {
    this.empName = argEmpName;
  }
  /**
   *
   * @param argEmpEmailId to set employee emailid.
   */
  public final void setEmpEmailId(final String argEmpEmailId) {
    this.empEmailId = argEmpEmailId;
  }
  /**
   *
   * @param argEmpMobNo to set employee mobno.
   */
  public final void setEmpMobNo(final long argEmpMobNo) {
    this.empMobNo = argEmpMobNo;
  }
  /**
   *
   * @param argEmpDoj to set employee doj.
   */
  public final void setEmpDoj(final Date argEmpDoj) {
    this.empDoj = argEmpDoj;
  }
  /**
   *
   * @param argEmpDept to set employee dept.
   */
  public final void setEmpDept(final String argEmpDept) {
    this.empDept = argEmpDept;
  }
  /**
   *
   * @param argEmpMgrId to set employee mgrid.
   */
  public final void setEmpMgrId(final int argEmpMgrId) {
    this.empMgrId = argEmpMgrId;
  }
  /**
   *
   * @param argEmpLeaveBalance to set employee leavesBalance.
   */
  public final void setEmpLeaveBalance(final int argEmpLeaveBalance) {
    this.empLeaveBalance = argEmpLeaveBalance;
  }

  /**
   * The dao for employee.
   */
  private static EmployeeDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(EmployeeDAO.class);
  }

  /**
   * list all employee details.
   * @return all employees' details
   */
  public static Employee[] listAll() {

    List<Employee> es = dao().list();
    return es.toArray(new Employee[es.size()]);
  }

  /**
   * list employee details by id.
   * @param empID id to get employee details.
   * @return Employee
   */
  public static Employee listById(final int empID) {
    return dao().find(empID);
  }

  /**
   * @return dao() insert used to return the leave details.
   * @param empId id of the employee.
   * @param sdate leave applied on.
   * @param edate the start date to apply for leave.
   * @param leaveType the end date to apply for leave.
   * @param leastatus leave type to apply for leave.
   * @param leaveReason leave reason to apply for leave
   * @param dateApplied leave status will be in pending.
   * @param nday the balanced leaves.
   */
  public static String apply(final int empId, final Date sdate, final Date edate,
      final LeaveType leaveType, final LeaveStatus leastatus, final String leaveReason,
      final Date dateApplied, final int nday) {
    long nod1 = 0; Date tsdate = null; Date tedate = null;
    if (sdate.after(edate)) {
      System.out.println("\nEnd Leave Date cannot be less than Start Leave Date");
    } else {
      long diff = edate.getTime() - sdate.getTime();
      nod1 = diff / (1000 * 60 * 60 * 24) + 1;
    }
    LeaveDetails tempId = new LeaveDetails();
    if (nday < 0) {
      System.out.println("Number of days cannot be Negative");
    } else {
      if (nday != nod1) {
        System.out.println("Please enter the valid number of days applied");
      } else {
        tempId = dao().retriveEmpid(empId);
        if (tempId == null) {
          dao().insert(empId, sdate, edate, leaveType, leastatus, leaveReason, dateApplied, nday);
          dao().update(empId, nday);
          System.out.println("\nLeave Applied Successfully");
        } else {
          try {
            tedate = tempId.getLevEndDate();
            tsdate = tempId.getLevStartDate();
            if (sdate.compareTo(tsdate) >= 0 && sdate.compareTo(tedate) <= 0
                || edate.compareTo(tsdate) >= 0 && edate.compareTo(tedate) <= 0) {
              System.out.println("\nYou have already applied for Leave..!!");
            } else {
              dao().insert(empId, sdate, edate, leaveType, leastatus, leaveReason, dateApplied, nday);
              dao().update(empId, nday);
              System.out.println("\nLEAVE SUCCESSFULLY APPLIED");
            }
          } catch (NullPointerException exp) {
            System.out.println("\nEXCEPTION OCCURED");
          }
        }
      }
    }
    return "LEAVE SUCCESSFULLY APPLIED";
  }
}
