package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddMilestonePage {
	WebDriver driver;
	public AddMilestonePage(WebDriver driver){
		this.driver = driver;
	}
	
	By milestonename = By.id("milestoneName");
	
	public MilestonesPage addMile(String name){
		driver.findElement(milestonename).sendKeys(name);
		return new MilestonesPage(this.driver);
	}
	
}
