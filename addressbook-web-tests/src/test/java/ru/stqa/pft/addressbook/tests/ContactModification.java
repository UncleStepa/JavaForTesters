package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (! app.getContactHelper().isTeareContact()) {

            app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
                    "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
                    "stankevich@mail.ru", "test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        List<ContractInfo> before = app.getContactHelper().getContactList();
        int index = before.size()-1;
        ContractInfo contact = new ContractInfo("Fedor", "Fedyav", "Restov", "Povelitel",
                "Neoflex", "Samara", "City Samara, House 3", "+79231451234",
                "Fedor@mail.ru", null, before.get(index).getId());
        app.getContactHelper().contactModify(index, contact);
        List<ContractInfo> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContractInfo> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
