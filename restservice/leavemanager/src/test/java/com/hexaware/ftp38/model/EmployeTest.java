package com.hexaware.ftp38.model;

import com.hexaware.ftp38.persistence.EmployeeDAO;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Expectations;
import mockit.MockUp;
import mockit.Mocked;
import mockit.Mock;
import mockit.integration.junit4.JMockit;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

/**
 * Test class for Employee.
 */
@RunWith(JMockit.class)
public class EmployeTest {

  /**
   * setup method.
   */
  @Before
  public void initInput() {

  }

  /**
   * Tests the testequals methods of the employee class.
   */

  @Test
  public final void testEquals() {
    Date d = new Date(2018 - 03 - 15);
    Employee e1 = new Employee(3000, "POOJA GOPAL", "PoojagopalJ@hexaware.com", 12345, d,
        "ACCOUNTS", 2000, 1);
    Employee e2 = new Employee(3000, "POOJA GOPAL", "PoojagopalJ@hexaware.com", 12345, d,
        "ACCOUNTS", 2000, 1);
    assertEquals(e1, e2);
  }

  /**
   * Tests the equals/hashcode methods of the employee class.
   */
  @Test
  public final void testEmployee() {
    Employee e100 = new Employee(100);
    Employee e101 = new Employee(101);
    assertNotEquals(e100, null);
    assertNotEquals(e100, new Integer(100));
    assertEquals(e100, new Employee(100));
    assertNotEquals(e101, new Employee(100));
    assertEquals(e100.hashCode(), new Employee(100).hashCode());
    assertEquals(e100.getEmpId(), new Employee(100).getEmpId());
    e101.setEmpId(100);
    assertEquals(e101, new Employee(100));
  }
  /**
   * Tests the toString methods of the employee class.
   */
  @Test
  public final void testToString() {
    Date d1 = new Date(2014 - 05 - 14);
    String var1 = "EmpId : " + 2000 + " " + " empName: " + "RANI" + " " + " empEmailId: " + "RANI@hexaware.com" + " "
        + " empMobNo: " + 12356 + " " + " empDoj: " + d1 + " " + " empDept: " + "ACCOUNTS" + " " + " empMgrId: " + 1000
        + " " + " empLeaveBalance: " + 5;
    Employee emp1 = new Employee(2000, "RANI", "RANI@hexaware.com", 12356, d1, "ACCOUNTS", 1000, 5);
    assertEquals(var1, emp1.toString());
    Date d2 = new Date(2014 - 02 - 16);
    String var2 = "EmpId : " + 2001 + " " + " empName: " + "RANA" + " " + " empEmailId: " + "RANA@hexaware.com" + " "
        + " empMobNo: " + 12344 + " " + " empDoj: " + d2 + " " + " empDept: " + "MARKETING" + " " + " empMgrId: " + 1000
        + " " + " empLeaveBalance: " + 5;
    Employee emp2 = new Employee(2001, "RANA", "RANA@hexaware.com", 12344, d2, "MARKETING", 1000, 5);
    assertEquals(var2, emp2.toString());
    Date d3 = new Date(2018 - 03 - 15);
    String var3 = "EmpId : " + 3000 + " " + " empName: " + "POOJA GOPAL" + " "
        + " empEmailId: " + "Poojagopal@hexaware.com" + " "
        + " empMobNo: " + 12345 + " " + " empDoj: " + d3 + " " + " empDept: " + "ACCOUNTS" + " " + " empMgrId: " + 2000
        + " " + " empLeaveBalance: " + 5;
    Employee emp3 = new Employee(3000, "POOJA GOPAL", "Poojagopal@hexaware.com", 12345, d3, "ACCOUNTS", 2000, 5);
    assertEquals(var3, emp3.toString());
  }
  /**
   * Tests the getSet methods of the employee class.
   */
  @Test
  public final void testGetSet() {
    Date d1 = new Date(2014 - 05 - 14);
    Employee emp1 = new Employee(2000, "RANI", "RANI@hexaware.com",
                   12356, d1, "ACCOUNTS", 1000, 5);
    emp1.setEmpId(2000);
    emp1.setEmpName("RANI");
    emp1.setEmpEmailId("RANI@hexaware.com");
    emp1.setEmpMobNo(12356);
    emp1.setEmpDoj(d1);
    emp1.setEmpDept("ACCOUNTS");
    emp1.setEmpMgrId(1000);
    emp1.setEmpLeaveBalance(5);
    assertEquals(2000, emp1.getEmpId());
    assertEquals("RANI", emp1.getEmpName());
    assertEquals("RANI@hexaware.com", emp1.getEmpEmailId());
    assertEquals(12356, emp1.getEmpMobNo());
    assertEquals(d1, emp1.getEmpDoj());
    assertEquals("ACCOUNTS", emp1.getEmpDept());
    assertEquals(1000, emp1.getEmpMgrId());
    assertEquals(5, emp1.getEmpLeaveBalance());
    Date d2 = new Date(2014 - 02 - 16);
    Employee emp2 = new Employee(2001, "RANA", "RANA@hexaware.com",
                   12344, d2, "MARKETING", 1000, 5);
    emp2.setEmpId(2001);
    emp2.setEmpName("RANA");
    emp2.setEmpEmailId("RANA@hexaware.com");
    emp2.setEmpMobNo(12344);
    emp2.setEmpDoj(d2);
    emp2.setEmpDept("MARKETING");
    emp2.setEmpMgrId(1000);
    emp2.setEmpLeaveBalance(5);
    assertEquals(2001, emp2.getEmpId());
    assertEquals("RANA", emp2.getEmpName());
    assertEquals("RANA@hexaware.com", emp2.getEmpEmailId());
    assertEquals(12344, emp2.getEmpMobNo());
    assertEquals(d2, emp2.getEmpDoj());
    assertEquals("MARKETING", emp2.getEmpDept());
    assertEquals(1000, emp2.getEmpMgrId());
    assertEquals(5, emp2.getEmpLeaveBalance());
    Date d3 = new Date(2018 - 03 - 15);
    Employee emp3 = new Employee(3000, "POOJA GOPAL", "Poojagopal@hexaware.com",
                   12345, d3, "ACCOUNTS", 2000, 5);
    emp3.setEmpId(3000);
    emp3.setEmpName("POOJA GOPAL");
    emp3.setEmpEmailId("Poojagopal@hexaware.com");
    emp3.setEmpMobNo(12345);
    emp3.setEmpDoj(d3);
    emp3.setEmpDept("ACCOUNTS");
    emp3.setEmpMgrId(2000);
    emp3.setEmpLeaveBalance(5);
    assertEquals(3000, emp3.getEmpId());
    assertEquals("POOJA GOPAL", emp3.getEmpName());
    assertEquals("Poojagopal@hexaware.com", emp3.getEmpEmailId());
    assertEquals(12345, emp3.getEmpMobNo());
    assertEquals(d3, emp3.getEmpDoj());
    assertEquals("ACCOUNTS", emp3.getEmpDept());
    assertEquals(2000, emp3.getEmpMgrId());
    assertEquals(5, emp3.getEmpLeaveBalance());
  }
 /**
   * tests that empty employee list is handled correctly.
   * @para dao mocking the dao class
   */
  @Test
  public final void testHashCode() {
    Date d1 = new Date(2014 - 05 - 14);
    Employee emp1 = new Employee(2000, "RANI", "RANI@hexaware.com", 12356, d1, "ACCOUNTS", 1000, 5);
    assertEquals(new Employee(2000, "RANI", "RANI@hexaware.com", 12356, d1, "ACCOUNTS", 1000, 5)
            .hashCode(), emp1.hashCode());
    Date d2 = new Date(2018 - 03 - 15);
    Employee emp2 = new Employee(1000, "RAJA", "RAJA@hexaware.com", 12342, d2, "ceo", 0, 5);
    assertEquals(new Employee(1000, "RAJA", "RAJA@hexaware.com", 12342, d2, "ceo", 0, 5)
            .hashCode(), emp2.hashCode());
  }
  /**
   * tests that hashcode is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllEmpty(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        dao.list(); result = new ArrayList<Employee>();
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(0, es.length);
  }

  /**
   * Tests that a list with some employees is handled correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListAllSome(@Mocked final EmployeeDAO dao) {
    new Expectations() {
      {
        ArrayList<Employee> es = new ArrayList<Employee>();
        es.add(new Employee(1));
        es.add(new Employee(10));
        es.add(new Employee(100));
        dao.list(); result = es;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee[] es = Employee.listAll();
    assertEquals(3, es.length);
    assertEquals(new Employee(1), es[0]);
    assertEquals(new Employee(10), es[1]);
    assertEquals(new Employee(100), es[2]);
  }

    /**
   * Tests that a fetch of a specific employee works correctly.
   * @param dao mocking the dao class
   */
  @Test
  public final void testListById(@Mocked final EmployeeDAO dao) {
    final Employee e100 = new Employee(100);
    new Expectations() {
      {
        dao.find(100); result = e100;
        dao.find(-1); result = null;
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    Employee e = Employee.listById(100);
    assertEquals(e100, e);

    e = Employee.listById(-1);
    assertNull(e);
  }
   /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws the exception.
   */
  @Test
  public final void testInsert(@Mocked final EmployeeDAO dao) throws ParseException {
    final LeaveType lt = LeaveType.EARNEDLEAVE;
    final LeaveStatus lsp = LeaveStatus.PENDING;
    final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        dao.insert(2000, df.parse("2018-05-15"), df.parse("2018-05-16"), lt, lsp, "FEVER",
            df.parse("2018-05-14"), 2);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String s = null;
    s = Employee.apply(2000, df.parse("2018-05-15"), df.parse("2018-05-16"), lt, lsp, "FEVER",
    df.parse("2018-05-14"), 2);
    assertEquals("LEAVE SUCCESSFULLY APPLIED", s);
  }
   /**
   * tests that empty employee list is handled correctly.
   * @param dao mocking the dao class
   * @throws ParseException throws the exception.
   */
  @Test
  public final void testAutoApprove(@Mocked final EmployeeDAO dao) throws ParseException {
    final LeaveType lt = LeaveType.EARNEDLEAVE;
    final LeaveStatus lsp = LeaveStatus.APPROVED;
    final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    new Expectations() {
      {
        final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        dao.insert(1000, df.parse("2018-05-15"), df.parse("2018-05-15"), lt, lsp, "FEVER",
            df.parse("2018-05-14"), 1);
      }
    };
    new MockUp<Employee>() {
      @Mock
      EmployeeDAO dao() {
        return dao;
      }
    };
    String s = null;
    s = Employee.apply(1000, df.parse("2018-05-15"), df.parse("2018-05-15"), lt, lsp, "FEVER",
    df.parse("2018-05-14"), 1);
    assertEquals("LEAVE SUCCESSFULLY APPLIED", s);
  }
}
