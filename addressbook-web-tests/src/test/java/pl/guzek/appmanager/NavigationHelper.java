package pl.guzek.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Pawel on 30.04.2017.
 */
public class NavigationHelper extends HelperBase {


    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public void gotoGroupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Grupy")
                && isElementPresent(By.name("new"))) {return;}



     click(By.linkText("grupy"));

}

    public void gotoHomePage() {
        if(isElementPresent(By.id("maintable"))){
            return;
        }
        click(By.linkText("strona główna"));
    }

}
