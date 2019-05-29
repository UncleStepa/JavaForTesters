package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactFirstDelete extends TestBase {

    @Test
    public void testDeleteOneGroup(){
        app.getContactHelper().selectFirstContact();
        app.getContactHelper().deleteOneContact();
        app.getContactHelper().submitDeleteContact();
        app.getNavigationHelper().goToHomePage();
    }
}
