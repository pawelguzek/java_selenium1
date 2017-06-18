package pl.guzek.tests;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.guzek.model.ContactData;
import pl.guzek.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Anna on 2016-12-11.
 */
public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.goTo().newContact();
            app.contact().create(new ContactData().withName("Jan").withSurname("Kowalski").withAddress("Zielona 7").withHomeNumber("675-76-16").withMobileNumber("123 43 23").withWorkNumber("(44)-67-678").withGroup("test1"));
        }
    }
    @Test
    public void testContactModification(){
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData().withId(modifiedContact.getId()).withName("Jan").withSurname("Kowalski").withAddress("Zielona 7").withMobileNumber("123543123");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}