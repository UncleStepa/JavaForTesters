package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


  public void selectgroupById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']" )).click();}

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public int count(){
    return wd.findElements(By.name("selected[]")).size();
  }


  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCashe = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectgroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCashe = null;
    returnToGroupPage();
  }

  public void delete(GroupData group) {
    selectgroupById(group.getId());
    deleteSelectedGroup();
    groupCashe = null;
    returnToGroupPage();
  }

  public boolean isThereaGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  private Groups groupCashe = null;

  public Groups all() {
    if (groupCashe !=null) {
      return new Groups(groupCashe);
    }
    groupCashe = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element : elements) {
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCashe.add(new GroupData().withId(id).withName(name));
    }
    return new Groups(groupCashe);
  }


}
