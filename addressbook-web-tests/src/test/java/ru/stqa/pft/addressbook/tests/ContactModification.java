package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (! app.contact().isTeareContact()) {
            app.contact().createContact(new ContractInfo().
                    whithFirstname("Vasya").whithMiddlename("Igorevich").whithLastname("Stankevich").whithNickname("UncleStepa").whithCompanyWork("Neoflex")
                    .whithCityName("Saratov").whithFullAddress("City Saratov, House 3").whithFhoneNumber("+7923145444").whithEmail("stankevich@mail.ru")
                    .whithGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification(){
        List<ContractInfo> before = app.contact().list();
        int index = before.size()-1;
        ContractInfo contact = new ContractInfo().
                whithFirstname("Fedor").whithMiddlename("Revov").whithLastname("Perfecto").whithNickname("Netu").whithCompanyWork("Neoflex")
                .whithCityName("Saratov").whithFullAddress("City Saratov, House 3").whithFhoneNumber("+7923145444").whithEmail("stankevich@mail.ru")
                .whithGroup("test1").whithId(before.get(index).getId());
        app.contact().contactModify(index, contact);
        List<ContractInfo> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size());
        before.remove(index);
        before.add(contact);
        Comparator<? super ContractInfo> byId = (q1, q2) -> Integer.compare(q1.getId(), q2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(after, before);
    }
}
