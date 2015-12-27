package teamworktests;

import java.awt.SecondaryLoop;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import teamworktests.AddTaskListPage;
import teamworktests.LoginPage;
import teamworktests.MilestonesPage;
import teamworktests.OverviewPage;
import teamworktests.TaskListPage;
import teamworktests.TasksPage;

public class NewTest {
	WebDriver driver;
	@Test
	public void first() throws InterruptedException {
		String tasklistname = "yabadaba";
		LoginPage log = new LoginPage(driver);
		OverviewPage over =  log.login("fake11@fake.com", "fake");
		TasksPage task = over.clickTasks();
		AddTaskListPage addt = task.addTaskList();
		task = addt.addTaskList(tasklistname);
		TaskListPage tpage = task.clickTaskList(tasklistname);
	
		tpage.clickAdd();
		tpage.addTask("task1");
		Thread.sleep(5000);
		tpage.addTask("task2");
		MilestonesPage mile = tpage.clickMilestone();
		
		TasksPage task1 = mile.clickTasks();
		tpage = task1.clickTaskList(tasklistname);
		//Assert.assertTrue(driver.findElements(By.xpath("//*[text()='blabla']")).size() > 0);
		//Assert.assertTrue(driver.findElements(By.xpath("//*[text()='2blabla2']")).size() > 0);
		Assert.assertEquals(tpage.cntList(), 2);
		tpage.delTaskList();
		
	}
	
	@Test
	public void second(){
		String tasklistname = "yabadaba";
		String milestonename = "mls";
		LoginPage log = new LoginPage(driver);
		OverviewPage over =  log.login("fake11@fake.com", "fake");
		TasksPage task = over.clickTasks();
		AddTaskListPage addt = task.addTaskList();
		task = addt.addTaskList(tasklistname);
		MilestonesPage mil = task.clickMilestone();
		mil.addMilsone(milestonename);
		mil.atttachMilstone(milestonename, tasklistname);
		task = mil.clickTasks();
		TaskListPage tpage = task.clickTaskList(tasklistname); 
		Assert.assertTrue(driver.findElements(By.linkText("milestone334")).size() > 0);
		tpage.delTaskList();
		
	}
	@BeforeMethod
	public void beforeTest() {
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://topq.teamwork.com");
		
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
