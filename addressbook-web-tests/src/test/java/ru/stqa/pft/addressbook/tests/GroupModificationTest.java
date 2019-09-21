package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import java.util.Set;

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

        Set<GroupData> before = app.group().all();
        GroupData modifydGroup = before.iterator().next();
        GroupData group = new GroupData()
                .withName("res").withFooter("res1").withHeader("res2").withId(modifydGroup.getId());
        app.group().modify(group);
        Set<GroupData> after = app.group().all();
        Assert.assertEquals(after.size(), before.size());
        before.remove(modifydGroup);
        before.add(group);
        Assert.assertEquals(after, before);
    }


}
