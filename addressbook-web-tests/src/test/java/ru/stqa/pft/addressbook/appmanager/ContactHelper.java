package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public void submitContactCreation() {
        click(By.xpath("(//input[@name='submit'])[2]"));
    }


    public void fillContactGroup(ContractInfo personInfo, boolean creation) {
        type(By.name("firstname"), personInfo.getFirstname());
        type(By.name("middlename"), personInfo.getMiddlename());
        type(By.name("lastname"), personInfo.getLastname());
        type(By.name("nickname"), personInfo.getNickname());
        type(By.name("company"), personInfo.getCompanyWork());
        type(By.name("home"), personInfo.getCityName());
        type(By.name("address"), personInfo.getFullAddress());
        type(By.name("mobile"), personInfo.getFhoneNumber());
        type(By.name("email"), personInfo.getEmail());

        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(personInfo.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));

        }
    }


    public void selectFirstContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']" )).click();}


    public void deleteOneContact() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void goToContactCreationPage() {
        click(By.linkText("add new"));
    }

    public void submitDeleteContact() {
        alert();
    }

    public void selectEditContractById(int id) {
        wd.findElement(By.cssSelector("a[href='edit.php?id="+ id +"']")).click();
    }

    public void updateModificationContract() {
        click(By.name("update"));
    }

    public void createContact(ContractInfo contractInfo, boolean creation) {
        goToContactCreationPage();
        fillContactGroup(contractInfo, creation);
        submitContactCreation();
        returnToHomePage();
    }

    public void modify( ContractInfo contact) {
        selectEditContractById(contact.getId());
        fillContactGroup(contact, false);
        updateModificationContract();
        returnToHomePage();
    }

    public void delete(ContractInfo contact) {
        selectFirstContactById(contact.getId());
        deleteOneContact();
        submitDeleteContact();
        returnToHomePage();
    }

    public boolean isTeareContact() {
        return isElementPresent(By.name("selected[]"));
    }


    public Contacts all() {
        Contacts contacts = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            contacts.add(new ContractInfo().withId(id).withLastname(lastname).withFirstname(firstname));
        }
        return contacts;
    }
}
