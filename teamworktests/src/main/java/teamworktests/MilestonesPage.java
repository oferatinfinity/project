package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class MilestonesPage extends AbstractMainBar {
	public MilestonesPage(WebDriver driver){
		super(driver);
	}
	String milsestonename;
	String tasklist;
	By addNew = By.xpath("//span[@class='btn-addIcon']");
	By addmilestone = By.id("ordLoginSubmitBtn");
	//By findmilestone = By.linkText(milsestonename);

	public AddMilestonePage addMilsone(String name){
		driver.findElement(addNew).click();
		driver.findElement(addmilestone).click();
		return new AddMilestonePage(this.driver);
	}
	
	public void atttachMilstone(String mname, String listname){
		milsestonename = mname;
		Actions actions = new Actions(driver);
		WebElement moveon = driver.findElement(By.linkText(mname));
		actions.moveToElement(moveon);
		actions.perform();
		driver.findElement(By.linkText("Attach task list")).click();
		Select drp = new Select(driver.findElement(By.xpath("//select[contains(.,taskListId)]")));
		drp.selectByVisibleText(listname);
	}
	
	
}
