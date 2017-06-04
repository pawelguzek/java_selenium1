package pl.guzek.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.guzek.model.ContactData;
import pl.guzek.model.Contacts;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Anna on 2016-12-11.
 */
public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.goTo().newContact();
            app.contact().create(new ContactData().withName("Jan").withSurname("Kowalski").withAddress("Zielona 7").withHomeNumber("675-76-16").withMobileNumber("123 43 23").withWorkNumber("(44)-67-678").withEmail1("kowalski@poczta.pl").withGroup("test1"));
        }
    }
    @Test
    public void testContactDeletion() {
        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size()-1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before.without(deletedContact)));
    }


}