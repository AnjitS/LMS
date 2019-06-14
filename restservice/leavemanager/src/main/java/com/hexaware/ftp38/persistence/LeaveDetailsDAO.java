package com.hexaware.ftp38.persistence;

import com.hexaware.ftp38.model.LeaveDetails;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import com.hexaware.ftp38.model.LeaveStatus;
import java.util.List;

/**
 * The DAO class for employee leave details.
 */
public interface LeaveDetailsDAO  {
  /**
   * return all the leave details of all the employees.
   * @return the employee array
   */
  @SqlQuery("SELECT * FROM LEAVE_DETAILS")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> list();

  /**
   * return all the details of the selected leave.
   * @param empID the id of the employee
   * @return the leavedetails object
   */
  @SqlQuery("SELECT L.* FROM LEAVE_DETAILS L INNER JOIN EMPLOYEE E"
      + " ON E.EMP_ID=L.EMP_ID"
      + " WHERE E.EMP_MGRID= :empID AND L.LEV_STATUS='PENDING'"
      + " order by E.emp_name")
  @Mapper(LeaveDetailsMapper.class)
  List<LeaveDetails> find1(@Bind("empID") int empID);

  /**to update leavedetails.
   * @param levId leaveid.
   * @param mcom manager comments.
   * @param stat status.
   */
  @SqlUpdate("UPDATE LEAVE_DETAILS SET LEV_MGRCOMMENTS = :mcom, LEV_STATUS = :stat WHERE LEV_ID = :levId")
  void updLeaDetails(@Bind("levId") int levId, @Bind("mcom") String mcom, @Bind("stat") LeaveStatus stat);

  /**
   *to update the employee.
   * @param empid emp id.
   * @param days for number of days.
   */
  @SqlUpdate("UPDATE EMPLOYEE SET EMP_LEAVEBALANCE = EMP_LEAVEBALANCE + :days WHERE EMP_ID = :empID")
  void updLeaEmpDetails(@Bind("empID") int empid, @Bind("days") int days);

  /**
   * return all the history details of the selected employee.
   * @param empID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Leave_Details WHERE EMP_ID = :empID")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails find(@Bind("empID") int empID);
  /**
   * return all the history details of the selected employee.
   * @param levID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Leave_Details WHERE LEV_ID = :levID")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails leaFind(@Bind("levID") int levID);
  /**
   * return all the history details of the selected employee.
   * @param levID the id of the employee
   * @return the employee object
   */
  @SqlQuery("SELECT * FROM Leave_Details WHERE LEV_ID = :levID")
  @Mapper(LeaveDetailsMapper.class)
  LeaveDetails levFind(@Bind("levID") int levID);
  /**
   * close with no args is used to close the connection.
   */
  void close();
}
