package pl.guzek.tests;

import org.testng.annotations.Test;
import pl.guzek.model.GroupData;

/**
 * Created by Pawel on 01.05.2017.
 */
public class GroupModificationTests extends TestBase {

    @Test
    public void testGroupModification(){

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData("1edycja123", "1edycja1234", "1edycja12345"));
        app.getGroupHelper().submitGroupModification();
        app.getGroupHelper().returnToGroupPage();



    }

}
