package pl.guzek.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.guzek.model.GroupData;
import pl.guzek.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by Pawel on 01.05.2017.
 */
public class GroupModificationTests extends TestBase {


    @BeforeMethod
    public void ensurePreconditions(){
        app.getNavigationHelper().goTo();
        if(app.group().all().size() == 0){
            app.group().create(new GroupData().withName("test1"));
        }

    }

    @Test
    public void testGroupModification(){


        Groups before = app.group().all();
        GroupData modifyGroup = before.iterator().next();
        GroupData group = new GroupData().withId(modifyGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
        app.group().modify(group);
        assertThat(app.group().getGroupCount(),equalTo(before.size() ));
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size());

        MatcherAssert.assertThat(after, CoreMatchers.equalTo(before.without(modifyGroup).without(group)));

    }



}
