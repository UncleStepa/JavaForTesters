package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContractInfo()
              .withFirstname("Igor")
              .withLastname("Stankevich")
              .withFullAddress("Saratov")
              .withHome_phone("1111")
              .withMobile_phone("22222")
              .withWork_phone("3333")
              .withEmail("reut@.ru")
              .withGroup("test1"), true);
    }
  }


  @Test
  public void testContactPhones() {
    ContractInfo contact = app.contact().all().iterator().next();
    ContractInfo contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getHome_phone(), equalTo(cleaned(contactInfoFromEditForm.getHome_phone())));
    assertThat(contact.getMobile_phone(), equalTo(cleaned(contactInfoFromEditForm.getMobile_phone())));
    assertThat(contact.getWork_phone(), equalTo(cleaned(contactInfoFromEditForm.getWork_phone())));
  }

  public String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
