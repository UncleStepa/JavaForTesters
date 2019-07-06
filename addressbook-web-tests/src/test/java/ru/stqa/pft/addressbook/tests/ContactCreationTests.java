package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.List;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    List<ContractInfo> before = app.getContactHelper().getContactList();
    app.getContactHelper().createContact(new ContractInfo("Vasya", "Igorevich", "Stankevich", "UncleStepa",
            "Neoflex", "Saratov", "City Saratov, House 3", "+7923145444",
            "stankevich@mail.ru", "test1"), true);
    List<ContractInfo> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(before.size() - 1);
    Assert.assertEquals(after, before);
  }
}
