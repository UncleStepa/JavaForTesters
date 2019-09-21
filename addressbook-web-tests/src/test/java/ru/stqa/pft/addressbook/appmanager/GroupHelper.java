package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.xpath("/html/body/div/div[4]/div/i/a"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {

    if (groupData.getName() != null) {
      type(By.name("group_name"), groupData.getName());
    }
    if (groupData.getHeader() != null) {
    type(By.name("group_header"), groupData.getHeader());
    }

    if (groupData.getFooter() != null) {
    type(By.name("group_footer"), groupData.getFooter());
    }
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroup() {
    click(By.name("delete"));
  }

  public void selectgroup(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();}



  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }



  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  public void modify(int index, GroupData group) {
    selectgroup(index);
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    returnToGroupPage();
  }

  public void delete(int index) {
    selectgroup(index);
    deleteSelectedGroup();
    returnToGroupPage();
  }

  public boolean isThereaGroup() {
    return isElementPresent(By.name("selected[]"));
  }


  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<>();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
}
