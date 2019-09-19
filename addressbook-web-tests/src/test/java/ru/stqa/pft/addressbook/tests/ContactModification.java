package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {

    @Test
    public void testContactModification(){
        if (! app.getContactHelper().isTeareContact()) {

            app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
                    "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
                    "stankevich@mail.ru", "test1"), true);
        }

        List<ContractInfo> before = app.getContactHelper().getContactList();
        ContractInfo contact = new ContractInfo("Fedor", "Fedyav", "Restov", "Povelitel",
                "Neoflex", "Samara", "City Samara, House 3", "+79231451234",
                "Fedor@mail.ru", null, before.get(before.size() - 1).getId());
        app.getContactHelper().selectEditContract(before.size() - 1);
        app.getContactHelper().fillContactGroup(contact, false);
        app.getContactHelper().updateModificationContract();
        app.getContactHelper().returnToHomePage();
        List<ContractInfo> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());
        before.remove(before.size() - 1);
        before.add(contact);
        Comparator<? super ContractInfo> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
