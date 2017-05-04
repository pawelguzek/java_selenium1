package pl.guzek.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Pawel on 30.04.2017.
 */
public class SessionHelper extends HelperBase{

    public SessionHelper(WebDriver wd) {
        super(wd);
    }

    public void login(String username, String password) {
        type(By.name("user"),username);
        type(By.name("pass"),password);
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.id("LoginForm")).click();
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }
}
