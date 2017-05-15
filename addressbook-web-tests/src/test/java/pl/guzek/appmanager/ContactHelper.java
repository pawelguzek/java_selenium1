package pl.guzek.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.guzek.model.ContactData;

/**
 * Created by Pawel on 05.05.2017.
 */
public class ContactHelper extends HelperBase {
    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.partialLinkText("nowy wpis"));
    }

    public void fillContactForm(ContactData contactdata, boolean creation) {
        type(By.name("firstname"), contactdata.getFirstName());
        type(By.name("lastname"), contactdata.getLastName());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactdata.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }

    }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void initContactModification() {
        click(By.cssSelector("img[alt='Edytuj']"));
    }

    public void submitContactModification() {
        click(By.name("update"));
    }

    public void returnToHomePage() {
        click(By.linkText("strona główna"));

    }


}
