package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractInfo;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    List<ContractInfo> before = app.getContactHelper().getContactList();
    ContractInfo contact = new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
            "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
            "stankevich@mail.ru", "test1");
    app.getContactHelper().createContact(contact, true);
    List<ContractInfo> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
    before.add(contact);
    Comparator<? super ContractInfo> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
  }
}
