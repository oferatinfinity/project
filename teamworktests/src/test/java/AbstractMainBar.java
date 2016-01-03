package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class AbstractMainBar extends AbstractPageObject {
	
	By taskspage = By.id("tab_tasks");
	By milestonespage = By.id("tab_milestones");
	By mile2 = By.linkText("Milestones");

	public AbstractMainBar(WebDriver driver) {
		super(driver);
	}

	public TasksPage clickTasks() {
		//driver.findElement(taskspage).click();
		driver.findElement(By.id("tab_tasks")).click();
		return new TasksPage(this.driver);
	}

	public MilestonesPage clickMilestone() {
		//driver.findElement(milestonespage).click();
		driver.findElement(By.id("tab_milestones")).click();
		//driver.findElement(mile2).click();
		return new MilestonesPage(this.driver);
	}
}
