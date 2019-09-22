package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupData().withName("test1"));
        }
    }

    @Test
    public void testGroupModification(){

        Groups before = app.group().all();
        GroupData modifydGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withName("res").withFooter("res1").withHeader("res2").withId(modifydGroup.getId());
        app.group().modify(group);
        Groups after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifydGroup);
        before.add(group);
        assertThat(after.size(), equalTo(before.size()));
        assertThat(after, equalTo(before.withOut(modifydGroup).withAdded(group)));
    }


}
