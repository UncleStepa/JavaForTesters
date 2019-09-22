package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

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
    Contacts before = app.contact().all();
    ContractInfo deletedContact = before.iterator().next();
    app.contact().delete(deletedContact);
    Contacts after = app.contact().all();
    assertThat(after.size(), equalTo(before.size() - 1));
    assertThat(after, equalTo(before.withOut(deletedContact)));
  }
}
