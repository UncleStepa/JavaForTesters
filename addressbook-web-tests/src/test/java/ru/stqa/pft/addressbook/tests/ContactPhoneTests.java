package ru.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase{

  @BeforeMethod
  public void ensurePrecondition() {
    if (app.contact().all().size() == 0) {
      app.contact().createContact(new ContractInfo()
              .withFirstname("Igor")
              .withLastname("Stankevich")
              .withFullAddress("Saratov, dom2, kv 123")
              .withHome_phone("1111")
              .withMobile_phone("22222")
              .withWork_phone("3333")
              .withEmail("reut@.ru")
              .withEmail1("1111@.gh")
              .withEmail2("zsdfsdfs@.ru")
              .withGroup("test1"), true);
    }
  }

  @Test
  public void testContactEmailPhonesAddress() {
    ContractInfo contact = app.contact().all().iterator().next();
    ContractInfo contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllFhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getFullAddress(), equalTo(contactInfoFromEditForm.getFullAddress()));
    assertThat(contact.getAllEmails(), equalTo(mergeEmail(contactInfoFromEditForm).trim()));

  }

  private String mergePhones(ContractInfo contact) {
    return Arrays.asList(contact.getHome_phone(), contact.getMobile_phone(), contact.getWork_phone()).
            stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  private String mergeEmail(ContractInfo contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail1(), contact.getEmail2()).
            stream().filter((s) -> ! s.equals(""))
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String phone) {
    return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
  }
}
