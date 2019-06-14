package com.hexaware.ftp38.util;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import com.hexaware.ftp38.model.LeaveStatus;
import com.hexaware.ftp38.model.LeaveType;
import com.hexaware.ftp38.model.Employee;
import com.hexaware.ftp38.model.LeaveDetails;

/**
 * Class CliMain provides the command line interface to the leavemanagement
 * application.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");

  private void mainMenu() {
    System.out.println("Leave Management System");
    System.out.println("-----------------------");
    System.out.println("1. DisplayEmployeesDetails");
    System.out.println("2. ListEmployeeDetails");
    System.out.println("3. LeaveApplicationDetails");
    System.out.println("4. LeaveHistoryDetails");
    System.out.println("5. PendingLeaveRequest");
    System.out.println("6. Approve/Deny");
    System.out.println("7. Exit");
    try {
      int menuOption = option.nextInt();
      mainMenuDetails(menuOption);
    } catch (InputMismatchException e) {
      System.out.println("ENTER ANY NUMBER FROM 1-7");
    }
  }
  private void mainMenuDetails(final int selectedOption) {
    switch (selectedOption) {
      case 1:
        displayEmployeesDetails();
        break;
      case 2:
        listEmployeeDetails();
        break;
      case 3:
        applyLeave();
        break;
      case 4:
        leaveHistoryDetails();
        break;
      case 5:
        pendingLeaveRequest();
        break;
      case 6:
        autheriseRequests();
        break;
      case 7:
        exit();
        //Runtime.getRuntime().halt(0);
        break;
      default:
        System.out.println("Choose either 1, 2, 3, 4, 5, 6 or 7");
    }
    mainMenu();
  }
  private void listEmployeeDetails() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    Employee employee = Employee.listById(empId);
    if (employee == null) {
      System.out.println("Sorry,No such employee found");
    } else {
      System.out.println(employee.getEmpId() + "  " + employee.getEmpName() + "  "
          + employee.getEmpMobNo() + "  " + employee.getEmpEmailId() + "  " + employee.getEmpDoj()
          + "  " + employee.getEmpDept() + "  " + employee.getEmpMgrId() + "  " + employee.getEmpLeaveBalance());
    }
  }
  private void displayEmployeesDetails() {
    Employee[] employee = Employee.listAll();
    for (Employee e : employee) {
      System.out.println(e.getEmpId() + "  " + e.getEmpName() + "  " + e.getEmpEmailId() + "  "
          + e.getEmpMobNo() + "  " + e.getEmpDoj() + "  " + e.getEmpDept() + "  " + e.getEmpMgrId()
          + "  " + e.getEmpLeaveBalance());
    }
  }
  private void autheriseRequests() {
    try {
      System.out.println("Enter the LeaveID: ");
      int levId = option.nextInt();
      LeaveDetails leaved = LeaveDetails.leaListById(levId);
      if (leaved == null) {
        System.out.println("Sorry..!! No such LeaveID exists");
      } else {
        int eid = leaved.getEmpId();
        System.out.println("Empolyee id :" + eid);
        option.nextLine();
        System.out.println("Enter manager comments :");
        String mcom = option.nextLine();
        System.out.println("Enter status of the leave(APPROVED/DENIED/PENDING)");
        String stat = option.next();
        System.out.println(stat.toUpperCase());
        if (stat.equals("APPROVED") || stat.equals("DENIED") || stat.equals("PENDING")) {
          LeaveDetails.approveDeny(levId, eid, mcom, stat);
        }
      }
    } catch (InputMismatchException e) {
      System.out.println("Enter Correct Id");
    }
  }
  private void applyLeave() {
    Date sdate = null, edate = null, dateApplied = null;
    LeaveStatus leastatus = null;
    int empId = 0;
    Date d = new Date();
    SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    try {
      System.out.println("\nEnter Employee ID");
      empId = option.nextInt();
    } catch (InputMismatchException imp) {
      System.out.println(" Please enter a valid id format");
      mainMenu();
    }
    Employee emp1 = Employee.listById(empId);
    if (emp1 == null) {
      System.out.println(" No Such Employee Found");
    } else {
      System.out.println("\nYour leave balance is :" + emp1.getEmpLeaveBalance());
      if (emp1.getEmpLeaveBalance() == 0) {
        System.out.println("Sorry you dont have enough leave balance :");
      } else {
        System.out.println("\nEnter Leave Start Date (dd-MM-yyyy)");
        String cld = null;
        try {
          cld = option.next();
        } catch (InputMismatchException i) {
          System.out.println("\nPlease Enter the Date in (dd-MM-yyyy) Format");
          mainMenu();
        }
        try {
          sdate = df.parse(cld);
        } catch (ParseException e) {
          System.out.println("\nPlease Enter the Date in (dd-MM-yyyy) Format");
          mainMenu();
        }
        if (sdate.after(d)) {
          System.out.println("\nEnter Leave End Date (dd-MM-yyyy)");
          String ced = null;
          try {
            ced = option.next();
          } catch (InputMismatchException i) {
            System.out.println("\nPlease Enter the Date in (dd-MM-yyyy) Format");
            mainMenu();
          }
          try {
            edate = df.parse(ced);
          } catch (ParseException e) {
            System.out.println("\nPlease Enter the Date in (dd-MM-yyyy) Format");
            mainMenu();
          }
          System.out.println("\nEnter the number of days for leave");
          int nday = option.nextInt();
          dateApplied = java.util.Calendar.getInstance().getTime();
          System.out.println("\nYour applying Leave on " + df.format(dateApplied));
          System.out.println("\nEnter the Leave Type (EARNEDLEAVE)");
          String leatype = option.next();
          LeaveType leaveType = null;
          try {
            leaveType = LeaveType.valueOf(leatype);
          } catch (IllegalArgumentException exp) {
            System.out.println("Mismatch leave type");
            mainMenu();
          }
          if (emp1.getEmpMgrId() == 0) {
            leastatus = LeaveStatus.APPROVED;
          } else {
            leastatus = LeaveStatus.PENDING;
          }
          if (nday > emp1.getEmpLeaveBalance()) {
            System.out.println("\nYour number of days is more than leave balance");
          } else {
            System.out.println("\nEnter your Leave Reason");
            String leaveReason = option.next();
            Employee.apply(empId, sdate, edate, leaveType, leastatus, leaveReason, dateApplied, nday);
          }
        } else {
          System.out.println(" You cannot Apply for past date");
        }
      }
    }
  }
  private void pendingLeaveRequest() {
    System.out.println("Enter an Employee Id who is a Manager ");
    int empId = option.nextInt();
    Employee e = Employee.listById(empId);
    if (e == null) {
      System.out.println("Sorry,No such employee");
    } else {
      LeaveDetails[] lev1 = LeaveDetails.pending(empId);
      System.out.println("Emp_ID" + "  " + "LevId" + "  " + "LevStartDate" + "  " + "LevEndDate"
            + "  " + "LevAppliedOn" + "  " + "LevMgrComments" + "  " + "LevNoOfDays");
      for (LeaveDetails l : lev1) {
        System.out.println(l.getEmpId() + "    " + l.getLevId() + "    "
            + l.getLevStartDate() + "     " + l.getLevEndDate() + "    "
            + l.getLevAppliedOn() + "     " + l.getLevMgrComments() + "          "
            + l.getLevNoOfDays());
      }
    }
  }
  private void leaveHistoryDetails() {
    System.out.println("Enter an Employee Id");
    int empId = option.nextInt();
    LeaveDetails lev = LeaveDetails.listById(empId);
    if (lev == null) {
      System.out.println("Sorry,No such employee");
    } else {
      System.out.println("Emp_Id" + " " + "Lev_Id" + " " + "Lev_Start_Date" + " " + "Lev_End_Date" + "   " + "Lev_Type"
           + "     " + "Lev_Status" + "   " + "Lev_Reason" + "   " + "Lev_Applied_On" + "   "
           + "Lev_MgrComments" + "  " + "Lev_No_Of_Days");
      System.out.println(lev.getEmpId() + "    " + lev.getLevId() + "     "
           + lev.getLevStartDate() + "     " + lev.getLevEndDate() + "    " + lev.getLevType()
           + "    " + lev.getLevStatus() + "    " + lev.getLevReason() + "          " + lev.getLevAppliedOn()
           + "      " + lev.getLevMgrComments() + "              " + lev.getLevNoOfDays());
    }
  }
  private void exit() {
    System.exit(0);
  }

  /**
   * The main entry point.
   * @param ar the list of arguments
   */
  public static void main(final String[] ar) {
    final CliMain mainObj = new CliMain();
    mainObj.mainMenu();
  }
}
