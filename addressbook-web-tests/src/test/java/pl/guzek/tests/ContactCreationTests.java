package pl.guzek.tests;
import org.apache.xpath.SourceTree;
import org.testng.annotations.Test;
import pl.guzek.model.ContactData;
import pl.guzek.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void ContactCreationTests() {
        Contacts before = app.contact().all();
        app.goTo().newContact();
        File photo = new File("src/test/resources/02.jpg");
        ContactData contact = new ContactData().withName("Jan").withSurname("Kowalski").withAddress("Zielona 7").withHomeNumber("675-76-16")
                .withMobileNumber("123 43 23").withWorkNumber("(44)-67-678").withEmail1("kowalski@poczta.pl").withGroup("test1").withPhoto(photo);
        app.contact().create(contact);
        app.contact().returnToHomepage();
        assertThat(app.contact().count(), equalTo(before.size()+1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

}


