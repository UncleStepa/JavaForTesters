package ru.stqa.pft.addressbook.model;

public class GroupData {
  private final String name;

  public void setId(int id) {
    this.id = id;
  }

  private  int id;
  private final String header;
  private final String footer;


  public GroupData(String name, String header, String footer, int id) {
    this.name = name;
    this.id = id;
    this.header = header;
    this.footer = footer;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    GroupData groupData = (GroupData) o;

    return name != null ? name.equals(groupData.name) : groupData.name == null;

  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.id = Integer.MAX_VALUE;
    this.header = header;
    this.footer = footer;
  }


  @Override
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

}
