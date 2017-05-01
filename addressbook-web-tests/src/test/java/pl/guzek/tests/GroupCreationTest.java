package pl.guzek.tests;

import org.testng.annotations.Test;
import pl.guzek.model.GroupData;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {

        app.getGroupHelper().returnToGroupPage();
        app.getGroupHelper().initGroupCreation();
        app.getGroupHelper().fillGroupForm(new GroupData("test1321", "test2321", "test331"));
        app.getGroupHelper().sumbitGroupCreation();
        app.getNavigationHelper().gotoGroupPage();
    }

}
