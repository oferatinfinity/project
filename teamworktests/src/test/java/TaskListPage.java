package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class TaskListPage extends AbstractMainBar {

	public TaskListPage(WebDriver driver){
		super(driver);
	}
	By taskname = By.xpath("//form[@id='newTaskForm']//following::span/input[@placeholder]");
	By taskname2 = By.xpath("(//input[@placeholder='What needs to be done?'])[2]");
	By addtuskbtn = By.xpath("//button[@class= 'btn btn-success js-add-task btn-lg']");
	By optionsbtn = By.xpath("//button[@class='btn btn-default btn-hasIcon tipped']");
	By deletebtn = By.linkText("Delete");
	By list = By.xpath("//div[@class='taskListContent noSel']");

	
	
	public void clickAdd(){
		driver.findElement(addtuskbtn).click();
	}
	
	public void addTask(String name){
		Select mydrpdwn = new Select(driver.findElement(By.name("taskAssignedToUserId")));
		mydrpdwn.selectByVisibleText("fake11 fake11 (me)");
		driver.findElement(taskname2).sendKeys(name);
		driver.findElement(taskname2).submit();
	}
	
	public int cntList(){
		return driver.findElements(list).size();
	}
	public TasksPage delTaskList(){
		driver.findElement(optionsbtn).click();
		driver.findElement(deletebtn).click();
		return new TasksPage(this.driver);
	}
}
