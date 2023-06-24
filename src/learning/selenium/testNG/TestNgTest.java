package learning.selenium.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestNgTest {
  @Test
  public void testMethod1() {
	  
	  System.out.println("test frst method");
  }
  @Test
  public void testMethod2() {
	  
	  System.out.println("test second method");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("test beforeMethod");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("test afterMethod");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("test beforeClass");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("test afterClass");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("test beforeTest");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("test afterTest");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("test beforeSuite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("test afterSuite");
  }

}
