package teamworktests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class testm {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://topq.teamwork.com");
		String tasklistname = "yabadaba";
		LoginPage log = new LoginPage(driver);
		OverviewPage over =  log.login("fake11@fake.com", "fake");
		TasksPage task = over.clickTasks();
		AddTaskListPage addt = task.addTaskList();
		task = addt.addTaskList(tasklistname);
		TaskListPage tpage = task.clickTaskList(tasklistname);
		//Thread.sleep(3000);
		tpage.clickAdd();
		tpage.addTask("task1");
		Thread.sleep(5000);
		tpage.addTask("task2");
		MilestonesPage mile = tpage.clickMilestone();
		//driver.navigate().refresh();
		//Thread.sleep(3000);
		TasksPage task1 = mile.clickTasks();
		tpage = task1.clickTaskList(tasklistname);
		//Assert.assertTrue(driver.findElements(By.xpath("//*[text()='blabla']")).size() > 0);
		//Assert.assertTrue(driver.findElements(By.xpath("//*[text()='2blabla2']")).size() > 0);
		Assert.assertEquals(tpage.cntList(), 2);
		tpage.delTaskList();
	}
}
