package pl.guzek.tests;

import org.testng.annotations.Test;
import pl.guzek.model.ContactData;

/**
 * Created by Pawel on 05.05.2017.
 */
public class ContactModificationTests extends TestBase {



    @Test
    public void testCoontactModificaton(){
        app.getNavigationHelper().gotoHomePage();
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("NewTest_nameEDIT","NewTest_surnameEdit)", null), false);
        app.getContactHelper().submitContactModification();
        app.getContactHelper().returnToHomePage();


    }


}
