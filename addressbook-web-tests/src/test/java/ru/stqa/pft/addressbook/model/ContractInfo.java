package ru.stqa.pft.addressbook.model;

public class ContractInfo {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String companyWork;
  private final String cityName;
  private final String fullAddress;
  private final String fhoneNumber;
  private final String email;
  private String group;
  private int id;

  public ContractInfo(String firstname, String middlename, String lastname, String nickname, String companyWork, String cityName,
                      String fullAddress, String fhoneNumber, String email, String group, int id) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyWork = companyWork;
    this.cityName = cityName;
    this.fullAddress = fullAddress;
    this.fhoneNumber = fhoneNumber;
    this.email = email;
    this.group = group;
    this.id = id;
  }

  public ContractInfo(String firstname, String middlename, String lastname, String nickname, String companyWork, String cityName,
                      String fullAddress, String fhoneNumber, String email, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.companyWork = companyWork;
    this.cityName = cityName;
    this.fullAddress = fullAddress;
    this.fhoneNumber = fhoneNumber;
    this.email = email;
    this.group = group;
    this.id = Integer.MAX_VALUE;
  }



  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompanyWork() {
    return companyWork;
  }

  public String getCityName() {
    return cityName;
  }

  public String getFullAddress() {
    return fullAddress;
  }

  public String getFhoneNumber() {
    return fhoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public  String getGroup() { return  group;}

  @Override
  public String toString() {
    return "ContractInfo{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContractInfo that = (ContractInfo) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  public int getId() {
    return id;
  }
}
