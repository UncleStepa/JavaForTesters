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
}
