package com.hexaware.ftp38.model;

import com.hexaware.ftp38.persistence.DbConnection;
import com.hexaware.ftp38.persistence.LeaveDetailsDAO;
import java.util.Objects;
import java.util.List;
import java.util.Date;

/**
 * Leavedetails class to store employee leave details.
 * @author hexware
 */
public class LeaveDetails {

  /**
   * empId to store employee id.
   * levId to store employee leaveid.
   * levStartDate to store employee Leave start date.
   * levEndDate to store employee Leave end date.
   * levType to store employee Leave type.
   * levStatus to store employee Leave status.
   * levReason to store employee Leave reason.
   * levAppliedOn to store employee Leave applied on.
   * levMgrComments to store employee Leave manager comments.
   * levNoOfDays to store employee Leave no of days.
   */
  private int empId;
  private int levId;
  private Date levStartDate;
  private Date levEndDate;
  private LeaveType levType;
  private LeaveStatus levStatus;
  private String levReason;
  private Date levAppliedOn;
  private String levMgrComments;
  private int levNoOfDays;

  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    LeaveDetails lev = (LeaveDetails) obj;
    if (Objects.equals(empId, lev.empId) && Objects.equals(levId, lev.levId)
        && Objects.equals(levStartDate, lev.levStartDate) && Objects.equals(levEndDate, lev.levEndDate)
        && Objects.equals(levType, lev.levType) && Objects.equals(levStatus, lev.levStatus)
        && Objects.equals(levReason, lev.levReason) && Objects.equals(levAppliedOn, lev.levAppliedOn)
        && Objects.equals(levMgrComments, lev.levMgrComments)
        && Objects.equals(levNoOfDays, lev.levNoOfDays)) {
      return true;
    }
    return false;
  }

  @Override
  public final int hashCode() {
    return Objects.hash(empId, levId, levStartDate, levEndDate, levType,
    levStatus, levReason, levAppliedOn, levMgrComments, levNoOfDays);
  }
  /**
   * default constructor.
   */
  public LeaveDetails() {
  }
  /**
   * @param argEmpId to initialize employee id.
   */
  public LeaveDetails(final int argEmpId) {
    this.empId = argEmpId;
  }
  /**
   * @param argEmpId to initialize employee id.
   * @param argLevId to initialize employee leaveid.
   * @param argLevStartDate to initialize employee Leave start date.
   * @param argLevEndDate to initialize employee Leave end date.
   * @param argLevType to initialize employee Leave type.
   * @param argLevStatus to initialize employee Leave status.
   * @param argLevReason to initialize employee Leave reason.
   * @param argLevAppliedOn to initialize employee applied on.
   * @param argLevMgrComments to initialize employee manager comments.
   * @param argLevNoOfDays to initialize employee Leave no of days.
   */
  public LeaveDetails(final int argEmpId, final int argLevId, final Date argLevStartDate, final Date argLevEndDate,
      final LeaveType argLevType, final LeaveStatus argLevStatus, final String argLevReason,
      final Date argLevAppliedOn, final String argLevMgrComments, final int argLevNoOfDays) {
    this.empId = argEmpId;
    this.levId = argLevId;
    this.levStartDate = argLevStartDate;
    this.levEndDate = argLevEndDate;
    this.levType = argLevType;
    this.levStatus = argLevStatus;
    this.levReason = argLevReason;
    this.levAppliedOn = argLevAppliedOn;
    this.levMgrComments = argLevMgrComments;
    this.levNoOfDays = argLevNoOfDays;
  }


  @Override
  public final String toString() {
    return this.empId + " " + this.levId + " " + this.levStartDate + " " + this.levEndDate + " "
      + this.levType + " " + this.levStatus + " " + this.levReason + " "
      + this.levAppliedOn + " " + this.levMgrComments + " "
      + this.levNoOfDays;
  }

  /**
   * Gets the EmployeeId.
   * @return this Employee's ID.
   */
  public final int getEmpId() {
    return empId;
  }
  /**
   * Gets the Employee LeaveId.
   * @return this Employee's LeaveID.
   */
  public final int getLevId() {
    return levId;
  }
  /**
   * Gets the Employee Leave StartDate.
   * @return this Employee's Leave Startdate.
   */
  public final Date getLevStartDate() {
    return levStartDate;
  }
  /**
   * Gets the Employee Leave EndDate.
   * @return this Employee's Leave Enddate.
   */
  public final Date getLevEndDate() {
    return levEndDate;
  }
  /**
   * Gets the Employee Leave Type.
   * @return this Employee's Leave Type.
   */
  public final LeaveType getLevType() {
    return levType;
  }
  /**
   * Gets the Employee Leave Status.
   * @return this Employee's Leave Status.
   */
  public final LeaveStatus getLevStatus() {
    return levStatus;
  }
  /**
   * Gets the Employee Leave Reason.
   * @return this Employee's Leave Reason.
   */
  public final String getLevReason() {
    return levReason;
  }
  /**
   * Gets the Employee Leave Applied On.
   * @return this Employee's Leave Applied On .
   */
  public final Date getLevAppliedOn() {
    return levAppliedOn;
  }
  /**
   * Gets the Employee Leave MgrComments.
   * @return this Employee's Leave MgrComments.
   */
  public final String getLevMgrComments() {
    return levMgrComments;
  }
  /**
   * Gets the Employee Leave No Of Days.
   * @return this Employee's Leave No Of Days.
   */
  public final int getLevNoOfDays() {
    return levNoOfDays;
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
   * @param argLevId to set employee leave id.
   */
  public final void setLevId(final int argLevId) {
    this.levId = argLevId;
  }
  /**
   *
   * @param arglevStartDate to set employee leave StartDate.
   */
  public final void setLevStartDate(final Date arglevStartDate) {
    this.levStartDate  = arglevStartDate;
  }
   /**
   *
   * @param arglevEndDate to set employee leave EndDate.
   */
  public final void setLevEndDate(final Date arglevEndDate) {
    this.levEndDate  = arglevEndDate;
  }
  /**
   *
   * @param arglevType to set employee leave Type.
   */
  public final void setLevType(final LeaveType arglevType) {
    this.levType  = arglevType;
  }
   /**
   *
   * @param arglevStatus to set employee leave Status.
   */
  public final void setLevStatus(final LeaveStatus arglevStatus) {
    this.levStatus  = arglevStatus;
  }
  /**
   *
   * @param arglevReason to set employee leave Reason.
   */
  public final void setLevReason(final String arglevReason) {
    this.levReason  = arglevReason;
  }
   /**
   *
   * @param arglevAppliedOn to set employee leave Applied on.
   */
  public final void setLevAppliedOn(final Date arglevAppliedOn) {
    this.levAppliedOn  = arglevAppliedOn;
  }
   /**
   *
   * @param arglevMgrComments to set employee leave Manager Comments.
   */
  public final void setLevMgrComments(final String arglevMgrComments) {
    this.levMgrComments  = arglevMgrComments;
  }
   /**
   *
   * @param arglevNoOfDays to set employee leave No Of Days.
   */
  public final void setLevNoOfDays(final int arglevNoOfDays) {
    this.levNoOfDays  = arglevNoOfDays;
  }
   /**
   * The dao for employee LeaveDetails.
   */
  private static LeaveDetailsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(LeaveDetailsDAO.class);
  }
  /**
   * list all employee Leave details.
   * @return all employee's Leave details
   */
  public static LeaveDetails[] listAll() {

    List<LeaveDetails> es = dao().list();
    return es.toArray(new LeaveDetails[es.size()]);
  }
  /**
   * list employee LeaveDetails by id.
   * @param empID id to get employee LeaveDetails.
   * @return Employee
   */
  public static LeaveDetails listById(final int empID) {
    return dao().find(empID);
  }
  /**
   * list employee LeaveDetails by id.
   * @param levID id to get employee LeaveDetails.
   * @return Employee
   */
  public static LeaveDetails leaListById(final int levID) {
    return dao().leaFind(levID);
  }
  /**
   * list employee leave details by id.
   * @param empID id to get employee leave details.
   * @return Leave Details
   */

  public static LeaveDetails[] pending(final int empID) {
    List<LeaveDetails> es1 = dao().find1(empID);
    return es1.toArray(new LeaveDetails[es1.size()]);
  }
  /**
  * @param levId represents leave id.
  * @param empId represents employee id.
  * @param leaMgrComments represents manager comments.
  * @param leaStatus represents status of leave.
  * @return to return a message.
   */
  public static String approveDeny(final int levId, final int empId,
      final String leaMgrComments, final String leaStatus) {
    if (leaStatus.equals("APPROVED") || leaStatus.equals("PENDING")) {
      dao().updLeaDetails(levId, leaMgrComments, LeaveStatus.valueOf(leaStatus));
    } else if (leaStatus.equals("DENIED")) {
      dao().updLeaDetails(levId, leaMgrComments, LeaveStatus.valueOf(leaStatus));
      LeaveDetails l1 = LeaveDetails.listById(levId);
      int days = l1.getLevNoOfDays();
      dao().updLeaEmpDetails(empId, days);
    }
    return "updated";
  }
}
