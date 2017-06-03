package pl.guzek.tests;

import org.testng.annotations.Test;
import pl.guzek.model.ContactData;

/**
 * Created by Pawel on 05.05.2017.
 */
public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation(){
        app.goTo().gotoHomePage();
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("312Newtest_name", "231test_surname", "test1"), true);
        app.getContactHelper().submitContactCreation();
        app.getContactHelper().returnToHomePage();



    }

}
