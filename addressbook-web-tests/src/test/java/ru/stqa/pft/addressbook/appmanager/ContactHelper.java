package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.ContractInfo;

import java.util.List;

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
        contactsCashe = null;
        returnToHomePage();
    }

    public void modify( ContractInfo contact) {
        selectEditContractById(contact.getId());
        fillContactGroup(contact, false);
        updateModificationContract();
        contactsCashe = null;
        returnToHomePage();
    }

    public void delete(ContractInfo contact) {
        selectFirstContactById(contact.getId());
        deleteOneContact();
        submitDeleteContact();
        contactsCashe = null;
        returnToHomePage();
    }

    public int count(){
        return wd.findElements(By.name("entry")).size();
    }

    public boolean isTeareContact() {
        return isElementPresent(By.name("selected[]"));
    }

    private Contacts contactsCashe = null;

    public Contacts all() {
        if (contactsCashe != null) {
            return new Contacts(contactsCashe);
        }
        contactsCashe = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for(WebElement element : elements){
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String allPhones = element.findElement(By.xpath(".//td[6]")).getText();
            String[] phones = allPhones.split("\n");
            contactsCashe.add(new ContractInfo().withId(id).withLastname(lastname).withFirstname(firstname).withHome_phone(phones[0]).
                    withMobile_phone(phones[1]).withWork_phone(phones[2]));
        }
        return new Contacts(contactsCashe);
    }

    public ContractInfo infoFromEditForm(ContractInfo contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        wd.navigate().back();
        return new ContractInfo()
                .withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHome_phone(home).withMobile_phone(mobile).withWork_phone(work)
                .withEmail(email).withEmail(email);
    }

    private void initContactModificationById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }
}
