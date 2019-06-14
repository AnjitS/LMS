package com.hexaware.ftp38.model;

import com.hexaware.ftp38.persistence.LeaveDetailsDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;
import mockit.integration.junit4.JMockit;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;

import java.util.ArrayList;
import java.util.Date;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class LeaveDetailsTest {
  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }
  /**
   * Tests the toString methods of the LeaveDetails class.
   */
  @Test
  public final void testhashCode()  {
    Date d1 = new Date(2018 - 03 - 12);
    Date d2 = new Date(2018 - 05 - 18);
    Date d3 = new Date(2018 - 03 - 12);
    LeaveType l1 = LeaveType.EARNEDLEAVE;
    LeaveStatus s1 = LeaveStatus.PENDING;
    LeaveDetails emp1 = new LeaveDetails(3001, 23, d1, d2, l1, s1, "null", d3, "null", 12);
    assertEquals(new LeaveDetails(3001, 23, d1, d2, l1, s1, "null", d3, "null", 12)
             .hashCode(), emp1.hashCode());
    Date d4 = new Date(2018 - 03 - 11);
    Date d5 = new Date(2018 - 05 - 02);
    Date d6 = new Date(2018 - 04 - 05);
    LeaveType l2 = LeaveType.EARNEDLEAVE;
    LeaveStatus s2 = LeaveStatus.PENDING;
    LeaveDetails emp2 = new LeaveDetails(3002, 127, d4, d5, l2, s2, "NULL", d6, "NULL", 8);
    assertEquals(new LeaveDetails(3002, 127, d4, d5, l2, s2, "NULL", d6, "NULL", 8)
             .hashCode(), emp2.hashCode());
  }
   /**
   * Tests the toString methods of the leavedetail class.
   */

  @Test
  public final void testequals() {
    Date d1 = new Date(2018 - 05 - 10);
    Date d2 = new Date(2018 - 05 - 13);
    Date d3 = new Date(2018 - 05 - 8);
    LeaveType levtyp = LeaveType.EARNEDLEAVE;
    LeaveStatus levstat = LeaveStatus.PENDING;
    LeaveDetails lev = new LeaveDetails(3000, 1, d1, d2, levtyp, levstat, "frvr", d3, "okay", 4);
    LeaveDetails lev1 = new LeaveDetails(3000, 1, d1, d2, levtyp, levstat, "frvr", d3, "okay", 4);
    assertEquals(lev, lev1);
  }

  /**
   * tests that empty LeaveDetails list is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final LeaveDetailsDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<LeaveDetails>();
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails[] ld = LeaveDetails.listAll();
    assertEquals(0, ld.length);
  }
  /**
   * tests that LeaveDetails data is handled correctly.
   * @param dao of Leavedetails.
   */
  @Test
  public final void testpendingLeaveRequest(@Mocked final LeaveDetailsDAO dao) {
    final Date d1 = new Date(2018 - 05 - 20);
    final Date d2 = new Date(2018 - 05 - 25);
    final Date d3 = new Date(2018 - 04 - 27);
    System.out.println(d1);
    final LeaveType lt = LeaveType.EARNEDLEAVE;
    final LeaveStatus ls = LeaveStatus.PENDING;
    new Expectations() {
      {
        ArrayList list1 = new ArrayList();
        list1.add(new LeaveDetails(3004, 1, d1, d2, lt,
                 ls, "Sick", d3, "OK", 2));
        dao.find1(3004);
        result = list1;
        System.out.println(result);
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
          return dao;
      }
    };
    LeaveDetails[] emp1 = LeaveDetails.pending(3004);
    LeaveDetails[] samp1 = new LeaveDetails[1];
    samp1[0] = new LeaveDetails(3004, 1, d1, d2, lt, ls, "Sick", d3, "OK", 2);
    assertArrayEquals(samp1, emp1);

    new Expectations() {
      {
        ArrayList list1 = new ArrayList();
        list1.add(new LeaveDetails(3005, 2, d1, d2, lt,
                 ls, "Sick", d3, "OK", 2));
        dao.find1(3005);
        result = list1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
     LeaveDetailsDAO dao() {
          return dao;
      }
    };
    LeaveDetails[] emp2 = LeaveDetails.pending(3005);
    LeaveDetails[] samp2 = new LeaveDetails[1];
    samp2[0] = new LeaveDetails(3005, 2, d1, d2, lt, ls, "Sick", d3, "OK", 2);
    assertArrayEquals(samp2, emp2);
  }
  /**
   * tests that LeaveDetails data is handled correctly.
   * @param dao of Leavedetails.
   */
  @Test
  public final void testLeaveHistory(@Mocked final LeaveDetailsDAO dao) {
    final Date d1 = new Date(2018 - 05 - 20);
    final Date d2 = new Date(2018 - 05 - 25);
    final Date d3 = new Date(2018 - 04 - 27);
    final LeaveType lt = LeaveType.EARNEDLEAVE;
    final LeaveStatus ls = LeaveStatus.PENDING;
    new Expectations() {
      {
        ArrayList list1 = new ArrayList();
        list1.add(new LeaveDetails(3004, 1, d1, d2, lt,
                 ls, "Sick", d3, "OK", 2));
        dao.find(3004);
        result = list1;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
     LeaveDetailsDAO dao() {
          return dao;
      }
    };
    LeaveDetails leadata1 = LeaveDetails.listById(3004);
    LeaveDetails ld1 = new LeaveDetails(3004, 1, d1, d2, lt, ls, "Sick", d3, "OK", 2);
    assertEquals(ld1, leadata1);
    new Expectations() {
      {
        ArrayList list2 = new ArrayList();
        list2.add(new LeaveDetails(3005, 2, d1, d2, lt,
                 ls, "Sick", d3, "OK", 2));
        dao.find(3005);
        result = list2;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
     LeaveDetailsDAO dao() {
          return dao;
      }
    };
    LeaveDetails leadata2 = LeaveDetails.listById(3005);
    LeaveDetails ld2 = new LeaveDetails(3005, 2, d1, d2, lt, ls, "Sick", d3, "OK", 2);
    assertEquals(ld2, leadata2);
  }
  /**
   * Tests the toString methods of the leavedetail class.
   */
  @Test
  public final void testToString() {
    Date d1 = new Date(2014 - 05 - 14);
    Date d2 = new Date(2014 - 05 - 15);
    Date d3 = new Date(2014 - 05 - 13);
    LeaveType lt = LeaveType.EARNEDLEAVE;
    LeaveStatus lsp = LeaveStatus.PENDING;
    String var1 = 2000 + " " +  11 + " "  + d1 + " " + d2 + " " + lt + " " + lsp + " " + "FEVER "
                  + d3 + " " + "get well soon" + " " + 2;
    LeaveDetails emp1 = new LeaveDetails(2000, 11, d1, d2, lt, lsp, "FEVER", d3, "get well soon", 2);
    assertEquals(var1, emp1.toString());
    Date d4 = new Date(2014 - 05 - 15);
    Date d5 = new Date(2014 - 05 - 19);
    Date d6 = new Date(2014 - 05 - 13);
    String var2 = 2001 + " " +  12 + " "  + d4 + " " + d5 + " " + lt + " " + lsp + " " + "vacation "
                  + d6 + " " + "have fun" + " " + 5;
    LeaveDetails emp2 = new LeaveDetails(2001, 12, d4, d5, lt, lsp, "vacation", d6, "have fun", 5);
    assertEquals(var2, emp2.toString());
    Date d7 = new Date(2014 - 05 - 16);
    Date d8 = new Date(2014 - 05 - 18);
    Date d9 = new Date(2014 - 05 - 13);
    String var3 = 3000 + " " +  13 + " "  + d7 + " " + d8 + " " + lt + " " + lsp + " " + "sick "
                  + d6 + " " + "get well soon" + " " + 5;
    LeaveDetails emp3 = new LeaveDetails(3000, 13, d4, d5, lt, lsp, "sick", d6, "get well soon", 5);
    assertEquals(var3, emp3.toString());
  }
  /**
   * Tests the constructor methods of the leavedetail class.
   */
  @Test
  public final void testLeaveDetails() {
    LeaveDetails e100 = new LeaveDetails(100);
    LeaveDetails e101 = new LeaveDetails(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new LeaveDetails(100));
    assertNotEquals(e101, new LeaveDetails(100));
    assertEquals(e100.hashCode(), new LeaveDetails(100).hashCode());
    assertEquals(e100.getEmpId(), new LeaveDetails(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new LeaveDetails(100));
  }

  /**
   * Tests the getSet methods of the LeaveDetails class.
   */
  @Test
  public final void testGetSet() {
    Date d1 = new Date(2014 - 05 - 14);
    Date d2 = new Date(2014 - 05 - 16);
    Date d3 = new Date(2014 - 05 - 13);
    LeaveStatus ls = LeaveStatus.PENDING;
    LeaveType lt = LeaveType.EARNEDLEAVE;
    LeaveDetails emp1 = new LeaveDetails(2000, 1, d1, d2, lt, ls, "sick", d3, "done", 2);
    LeaveDetails emp2 = new LeaveDetails(2001, 2, d1, d2, lt, ls, "sick", d3, "done", 2);
    emp1.setEmpId(2000);
    emp1.setLevId(1);
    emp1.setLevStartDate(d1);
    emp1.setLevEndDate(d2);
    emp1.setLevType(lt);
    emp1.setLevStatus(ls);
    emp1.setLevReason("sick");
    emp1.setLevAppliedOn(d3);
    emp1.setLevMgrComments("done");
    emp1.setLevNoOfDays(2);
    assertEquals(2000, emp1.getEmpId());
    assertEquals(1, emp1.getLevId());
    assertEquals(d1, emp1.getLevStartDate());
    assertEquals(d2, emp1.getLevEndDate());
    assertEquals(lt, emp1.getLevType());
    assertEquals(ls, emp1.getLevStatus());
    assertEquals("sick", emp1.getLevReason());
    assertEquals(d3, emp1.getLevAppliedOn());
    assertEquals("done", emp1.getLevMgrComments());
    assertEquals(2, emp1.getLevNoOfDays());

    emp2.setEmpId(2001);
    emp2.setLevId(2);
    emp2.setLevStartDate(d1);
    emp2.setLevEndDate(d2);
    emp2.setLevType(lt);
    emp2.setLevStatus(ls);
    emp2.setLevReason("sick");
    emp2.setLevAppliedOn(d3);
    emp2.setLevMgrComments("done");
    emp2.setLevNoOfDays(2);
    assertEquals(2001, emp2.getEmpId());
    assertEquals(2, emp2.getLevId());
    assertEquals(d1, emp2.getLevStartDate());
    assertEquals(d2, emp2.getLevEndDate());
    assertEquals(lt, emp2.getLevType());
    assertEquals(ls, emp2.getLevStatus());
    assertEquals("sick", emp2.getLevReason());
    assertEquals(d3, emp2.getLevAppliedOn());
    assertEquals("done", emp2.getLevMgrComments());
    assertEquals(2, emp2.getLevNoOfDays());
  }

   /**
   * tests inserting manager comments in approve, deny pending leaves.
   * @param dao for dao
   */
  @Test
  public final void testapproveDenyInsert(@Mocked final LeaveDetailsDAO dao) {
    final LeaveStatus leavestatus = LeaveStatus.APPROVED;
    if (leavestatus == LeaveStatus.APPROVED) {
      new Expectations() {
        {
          dao.updLeaDetails(1, "OK", leavestatus);
        }
      };
      new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
          return dao;
        }
      };
      LeaveDetails la = new LeaveDetails();
      assertEquals("updated", la.approveDeny(1, 3000, "OK", "APPROVED"));
    } else if (leavestatus == LeaveStatus.DENIED) {
      new Expectations() {
        {
          dao.updLeaDetails(1, "OK", leavestatus);
          dao.updLeaEmpDetails(3000, 2);
        }
      };
      new MockUp<LeaveDetails>() {
        @Mock
        LeaveDetailsDAO dao() {
          return dao;
        }
      };
      LeaveDetails lad = new LeaveDetails();
      assertEquals("updated", lad.approveDeny(1, 3000, "OK", "DENIED"));
    }
  }
  private final LeaveDetails lad1 = new LeaveDetails();
  /**
  * tests approve, deny pending leaves.
  * @param dao for dao
  * @throws ParseException to use simple date format.
  */
  @Test
  public final void testapproveDenyFetch(@Mocked final LeaveDetailsDAO dao) {
    final Date d1 = new Date(2018 - 05 - 8);
    final Date d2 = new Date(2018 - 05 - 10);
    final Date d3 = new Date(2018 - 05 - 11);
    final LeaveType leavetype = LeaveType.EARNEDLEAVE;
    final LeaveStatus leavestatus = LeaveStatus.PENDING;
    final LeaveStatus leavStatus1 = LeaveStatus.APPROVED;
    new Expectations() {
      {
        ArrayList<LeaveDetails> adf = new ArrayList<LeaveDetails>();
        adf.add(new LeaveDetails(3000, 1, d1, d2, leavetype,
            leavestatus, "SICK", d3, "OK", 2));
        dao.find(1);
        result = adf;
      }
    };
    new MockUp<LeaveDetails>() {
      @Mock
      LeaveDetailsDAO dao() {
        return dao;
      }
    };
    LeaveDetails lad2 = lad1.listById(1);

    LeaveDetails la = new LeaveDetails();
    la = (new LeaveDetails(3000, 1, d1, d2, leavetype,
           leavestatus, "SICK", d3, "OK", 2));
    assertEquals(la, lad2);
  }
}
