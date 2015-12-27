package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddTaskListPage {
	WebDriver driver;
	private By namefield = By.id("newTaskListName"); 
	private By submitbutton = By.id("btnCreateTaskList");

	public AddTaskListPage(WebDriver driver){
		this.driver = driver;
	}

	public TasksPage addTaskList(String name){
		driver.findElement(namefield).sendKeys(name);
		driver.findElement(submitbutton).click();
		return new TasksPage(this.driver);
	}

}
