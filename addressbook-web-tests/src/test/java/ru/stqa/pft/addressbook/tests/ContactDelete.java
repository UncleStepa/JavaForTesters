package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.List;
import java.util.Set;

public class ContactDelete extends TestBase {

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContractInfo().
              withFirstname("Vasya").withMiddlename("Igorevich").withLastname("Stankevich").withNickname("UncleStepa").withCompanyWork("Neoflex")
              .withCityName("Saratov").withFullAddress("City Saratov, House 3").withFhoneNumber("+7923145444").withEmail("stankevich@mail.ru")
              .withGroup("test1"), true);
    }
  }

  @Test
  public void testDeleteOneContact() {
    Set<ContractInfo> before = app.contact().all();
    ContractInfo deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Set<ContractInfo> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);
    before.remove(deletedContact);
    Assert.assertEquals(after, before);
  }
}
