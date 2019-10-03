package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (app.db().contacts().size() == 0){
            app.contact().createContact(new ContractInfo()
                    .withFirstname("Vasya")
                    .withLastname("Reytov")
                    .withFullAddress("Rim")
                    .withHome_phone("1111")
                    .withMobile_phone("22222")
                    .withWork_phone("3333")
                    .withEmail("reut@.ru")
                    .withEmail1("1111@.gh")
                    .withEmail2("zsdfsdfs@.ru")
                    .withPhoto(new File("src/test/resources/stru.png"))
                    .withGroup("test1"), true);
        }
    }


    @Test
    public void testContactModification(){
        Contacts before = app.db().contacts();
        ContractInfo modifyContact = before.iterator().next();
        ContractInfo contact = new ContractInfo()
                .withFirstname("Vasya")
                .withLastname("Revov")
                .withFullAddress("SPB")
                .withHome_phone("333")
                .withMobile_phone("22222")
                .withWork_phone("111")
                .withEmail("modif@.ru")
                .withEmail1("53535@.gh")
                .withEmail2("213123@.ru")
                .withPhoto(new File("src/test/resources/stru.png"))
                .withGroup("test1").withId(modifyContact.getId());
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.withOut(modifyContact).withAdded(contact)));
    }
}
