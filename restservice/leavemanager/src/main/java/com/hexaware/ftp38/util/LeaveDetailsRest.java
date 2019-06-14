package com.hexaware.ftp38.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.NotFoundException;

import com.hexaware.ftp38.model.LeaveDetails;
/**
 * This class provides a REST interface for the leavedetails entity.
 */
@Path("/leavedetails")
public class LeaveDetailsRest {
   /**
  *@return leavedetails for approve and deny.
  *@param levId is the leave id for the employee.
  */
  @GET
  @Path("/{levId}/levId")
  @Produces(MediaType.APPLICATION_JSON)
  public final LeaveDetails leaveApproveDeny(@PathParam("levId") final int levId) {
    System.out.println("LeaveDeatails");
    LeaveDetails st = LeaveDetails.leaListById(levId);
    if (st == null) {
      System.out.println("No such Leave ID: " + levId);
      throw new NotFoundException("No such Leave ID: " + levId);
    }
    return st;
  }
  /**
   * Returns the leave history.
   * @param lid for employee id.
   * @return a list of all the leaves
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("/{lid}/history")
  public final LeaveDetails leaveHistory(@PathParam("lid") final int lid) {
    LeaveDetails ld = LeaveDetails.listById(lid);
    return ld;
  }
  /**
   * @param empId for employee id.
   * @return arg returns the list of all the pending leaves
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Path("{empId}/pendleav")
  public final LeaveDetails[] pending(@PathParam("empId")final int empId) {
    final LeaveDetails[] arg = LeaveDetails.pending(empId);
    return arg;
  }
  /**
  *@return leavedetails for approve and deny.
  *@param empId is the employee id for the employee.
  *@param lea is the object of leave details for the employee.
  */
  @POST
  @Path("/{empId}/approveDeny")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public final String approveDenyRest(@PathParam("empId") final int empId,
      final LeaveDetails lea) {
    String st2 = LeaveDetails.approveDeny(lea.getLevId(), empId,
        lea.getLevMgrComments(), lea.getLevStatus().name());
    return st2;
  }
}
