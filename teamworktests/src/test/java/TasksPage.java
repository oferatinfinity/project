package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TasksPage extends AbstractMainBar {
	public TasksPage(WebDriver driver){
		super(driver);
	}

	By addtasklist = By.id("liBFOATL");

	public TaskListPage clickTaskList(String name){
		driver.findElement(By.linkText(name)).click();
		return new TaskListPage(this.driver);
	}

	public AddTaskListPage addTaskList(){
		//WebDriverWait wait = new WebDriverWait(driver,30);
		//wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(driver.findElement(addtasklist))));
		driver.findElement(addtasklist).click();
		return new AddTaskListPage(this.driver);
	}

}
