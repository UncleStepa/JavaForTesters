package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @Test
  public void testContactCreation()  {
    Contacts before = app.contact().all();
    ContractInfo contact = new ContractInfo()
            .withFirstname("Igor")
            .withLastname("Stankevich")
            .withFullAddress("Saratov, dom2, kv 123" +
                    "Rumaniya")
            .withHome_phone("1111")
            .withMobile_phone("22222")
            .withWork_phone("3333")
            .withEmail("reut@.ru")
            .withEmail1("1111@.gh")
            .withEmail2("zsdfsdfs@.ru")
            .withGroup("test1");
    app.contact().createContact(contact, true);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}
