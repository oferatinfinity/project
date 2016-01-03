package teamworktests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MainTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://topq.teamwork.com");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.findElement(By.id("userLogin")).sendKeys("fake11@fake.com");
		driver.findElement(By.id("password")).sendKeys("fake");
		driver.findElement(By.id("password")).submit();
		Thread.sleep(5000);
		driver.findElement(By.id("tab_tasks")).click();
		
		driver.findElement(By.id("liBFOATL")).click();
		driver.findElement(By.id("newTaskListName")).sendKeys("yabadabadu");
		driver.findElement(By.id("btnCreateTaskList")).click();
		driver.findElement(By.linkText("yabadabadu")).click();
		driver.findElement(By.xpath("//button[@class= 'btn btn-success js-add-task btn-lg']")).click();
		Select mydrpdwn = new Select(driver.findElement(By.name("taskAssignedToUserId")));
		mydrpdwn.selectByVisibleText("fake11 fake11 (me)");
		//String js = "arguments[0].style.height='auto'; arguments[0].style.visibility='visible';";
		//WebElement elem = driver.findElement(By.xpath("//html/body/table/tbody/tr/td[2]/div[2]/div/div/div/div/div[1]/div[3]/div/div[1]/div/div/div/div[2]/div[1]/div/form/div[1]/div[1]/div[1]/widget-typeahead/div/span/span[1]"));
		//((JavascriptExecutor) driver).executeScript(js, elem);
		//driver.findElement(By.xpath("//form[@id='newTaskForm']//following::span/input[@placeholder]")).sendKeys("lala");
		driver.findElement(By.xpath("(//input[@placeholder='What needs to be done?'])[2]")).sendKeys("blabla");
		driver.findElement(By.xpath("(//input[@placeholder='What needs to be done?'])[2]")).submit();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@placeholder='What needs to be done?'])[2]")).clear();
		driver.findElement(By.xpath("(//input[@placeholder='What needs to be done?'])[2]")).sendKeys("2blabla2");
		driver.findElement(By.xpath("(//input[@placeholder='What needs to be done?'])[2]")).submit();
		//driver.findElement(By.id("editTaskFormFooter0")).click();
		driver.findElement(By.id("tab_milestones")).click();
		driver.findElement(By.className("btn-addIcon")).click();
		driver.findElement(By.id("milestoneName")).sendKeys("milestone334");
		driver.findElement(By.id("milestoneName")).submit();
		Actions actions = new Actions(driver);
		WebElement moveon = driver.findElement(By.linkText("milestone334"));
		actions.moveToElement(moveon);
		actions.perform();
		driver.findElement(By.linkText("Attach task list")).click();
		Select drp = new Select(driver.findElement(By.xpath("//select[contains(.,taskListId)]")));
		drp.selectByVisibleText("yabadabadu");
		driver.findElement(By.id("tab_tasks")).click();
		driver.findElement(By.linkText("yabadabadu")).click();
		//Assert.assertTrue(driver.findElements(By.xpath("//*[text()='yabadabadu']/../..//*[text()='milestone334']")).size() > 0);
		Assert.assertTrue(driver.findElements(By.linkText("milestone334")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//*[text()='blabla']")).size() > 0);
		Assert.assertTrue(driver.findElements(By.xpath("//*[text()='2blabla2']")).size() > 0);
		driver.findElement(By.xpath("//button[@class='btn btn-default btn-hasIcon tipped']")).click();
		driver.findElement(By.linkText("Delete")).click();
		
		Thread.sleep(5000);
		
		
		
		driver.quit();
	}
}
