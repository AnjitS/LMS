package com.hexaware.ftp38.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;

import com.hexaware.ftp38.model.LeaveDetails;
import com.hexaware.ftp38.model.LeaveStatus;
import com.hexaware.ftp38.model.LeaveType;
/**
 * Mapper class to map from result set to leavedetails object.
 */
public class LeaveDetailsMapper implements ResultSetMapper<LeaveDetails> {
  /**
   * @param idx the index
   * @param rs the resultset
   * @param ctx the context
   * @return the mapped LeaveDetails object
   * @throws SQLException in case there is an error in fetching data from the resultset
   */
  public final LeaveDetails map(final int idx, final ResultSet rs, final      StatementContext ctx)
  throws SQLException {
    /**
     * @return LeaveDetails
     */
    return new LeaveDetails(rs.getInt("EMP_ID"), rs.getInt("LEV_ID"), rs.getDate("LEV_STARTDATE"),
    rs.getDate("LEV_ENDDATE"), LeaveType.valueOf(rs.getString("LEV_TYPE")),
    LeaveStatus.valueOf(rs.getString("LEV_STATUS")), rs.getString("LEV_REASON"),
    rs.getDate("LEV_APPLIED_ON"), rs.getString("LEV_MGRCOMMENTS"), rs.getInt("LEV_NO_OF_DAYS"));
  }
}
