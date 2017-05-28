package pl.guzek.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.guzek.model.GroupData;
import pl.guzek.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupCreationTest extends TestBase {

    @Test
    public void testGroupCreation() {


        app.getNavigationHelper().goTo();
        Groups before = app.group().all();
        GroupData group = new GroupData().withName("Test1");
        app.group().create(group);
        assertThat(app.group().getGroupCount(),equalTo(before.size() +1));
        Groups after = app.group().all();
        assertThat(after.size(),equalTo(before.size()+1));
        assertThat(after, equalTo(before.withAdded( group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
    }

}
