package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    Set<ContractInfo> before = app.contact().all();
    ContractInfo contact = new ContractInfo().
            withFirstname("rebus").withMiddlename("tetrty").withLastname("Stankevich").withNickname("UncleStepa").withCompanyWork("Neoflex")
            .withCityName("Saratov").withFullAddress("City Saratov, House 3").withFhoneNumber("+7923145444").withEmail("stankevich@mail.ru")
            .withGroup("test1");
    app.contact().createContact(contact, true);
    Set<ContractInfo> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);
    contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}
