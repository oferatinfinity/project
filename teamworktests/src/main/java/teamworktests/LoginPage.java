package teamworktests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
WebDriver driver;

public LoginPage(WebDriver driver){
	this.driver = driver;
}

By login = By.id("userLogin");
By pass = By.id("password");
By lgnbtn = By.id("ordLoginSubmitBtn");

public void enterUser(String user){
	driver.findElement(login).clear();
	driver.findElement(login).sendKeys(user);
}

public void enterPass(String password){
	driver.findElement(pass).clear();
	driver.findElement(pass).sendKeys(password);
}

public OverviewPage clickLogin(){
	driver.findElement(lgnbtn).click();
	return new OverviewPage(this.driver);
}

public OverviewPage login(String user, String password){
	enterUser(user);
	enterPass(password);
	return clickLogin();
	
}

}
