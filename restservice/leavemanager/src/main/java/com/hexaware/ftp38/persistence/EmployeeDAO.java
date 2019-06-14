package com.hexaware.ftp38.persistence;

import com.hexaware.ftp38.model.Employee;
import com.hexaware.ftp38.model.LeaveDetails;

import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.hexaware.ftp38.model.LeaveStatus;
import com.hexaware.ftp38.model.LeaveType;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import java.util.Date;


/**
 * The DAO class for employee.
 */
public interface EmployeeDAO  {
  /**
   * return all the details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM EMPLOYEE")
  @Mapper(EmployeeMapper.class)
  List<Employee> list();

  /**
   * return all the details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM EMPLOYEE WHERE EMP_ID = :empID")
  @Mapper(EmployeeMapper.class)
  Employee find(@Bind("empID") int empID);

  /**
   * return all the details of the selected employee.
   * @param empId id of the employee.
   * @param startDate the start date to apply for leave.
   * @param endDate the end date to apply for leave.
   * @param noOfDays number of days to apply for leave.
   * @param appliedDate applied date to apply for leave.
   * @param leaveType leave type to apply for leave.
   * @param leaveReason for leave reason.
   * @param leaveStatus for leave status.
   */
  @SqlUpdate("INSERT INTO LEAVE_DETAILS(EMP_ID, LEV_STARTDATE, LEV_ENDDATE,"
      + "LEV_TYPE, LEV_STATUS, LEV_REASON, LEV_APPLIED_ON, LEV_NO_OF_DAYS)"
        + "VALUES(:empId, :startDate, :endDate, :leaveType,  :leaveStatus,  :leaveReason, :appliedDate, :noOfDays)")
  void insert(@Bind("empId") int empId, @Bind("startDate") Date startDate,
        @Bind("endDate") Date endDate, @Bind("leaveType") LeaveType leaveType,
        @Bind("leaveStatus") LeaveStatus leaveStatus, @Bind("leaveReason") String leaveReason,
        @Bind("appliedDate") Date appliedDate,  @Bind("noOfDays") long noOfDays);

  /**
   * Update the Available Leave Balance of employee after apply leave.
   * @param empId to update particular employee data.
   * @param noOfDays to insert updated No Of Days in Leave Table.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVEBALANCE=EMP_LEAVEBALANCE-:noOfDays WHERE EMP_ID=:empId")
  void decrement(@Bind("empId") int empId, @Bind("noOfDays") long noOfDays);

  /**
   * Auto Approve for CEO.
   * @param empId to update particular employee data.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEAVE_STATUS='APPROVED' WHERE LEAVE_STATUS='PENDING' AND EMP_ID=:empId")
  void autoApprove(@Bind("empId") int empId);
  /**
   *use to return all the leave details of applying.
   * @param empid id of the employee.
   * @param noOfDay is the number of days.
   */

  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVEBALANCE=EMP_LEAVEBALANCE - :NOD WHERE EMP_ID= :EMP_ID")
  void update(@Bind("EMP_ID") int empid, @Bind("NOD") int noOfDay);
  /**
   * return all the details of the selected employee.
   * @param empId the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails retriveEmpid(@Bind("empID") int empId);


  /**
   * CLOSE.
   */
  void close();
}
