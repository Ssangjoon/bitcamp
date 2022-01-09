package com.eomcs.mylist.domain;

public class Contact {
  String name;
  String email;
  String tel;
  String company;

  public Contact() {
    System.out.println("Contact() 호출");
  }

  public Contact(String csvStr) {
    // 예)csvStr = "a,a@test.com,010,x"

    String[] values = csvStr.split(","); // ["a","a@test.com","010","x"]
    this.setName(values[0]);  // 배열에 들어있는 각 항목을 객체의 필드에 저장한다. 
    this.setEmail(values[1]);
    this.setTel(values[2]);
    this.setCompany(values[3]);
  }


  //적용기술
  // => 스태틱 메서드 : 특정 인스턴스에 종속되지 않고 사용하는 메서드.
  // => GoF의 'Factory Method'패턴
  //    객체 생성과정이 복잡할 경우 new 명령을 통해 직접 객체를 생성하는 대신에 
  //    메서드를 통해
  public static Contact valueOf(String csvStr) {
    // 예)csvStr = "a,a@test.com,010,x"

    String[] values = csvStr.split(","); // ["a","a@test.com","010","x"]

    Contact contact = new Contact();
    contact.setName(values[0]);  // 배열에 들어있는 각 항목을 객체의 필드에 저장한다. 
    contact.setEmail(values[1]);
    contact.setTel(values[2]);
    contact.setCompany(values[3]);

    return contact;
  }

  // 적용 기술
  // => 인스턴스 메서드 : 특정 인스턴스를 사용한다면 인스턴스 메서드로 만들라.
  // => + GRASP의 Information Export 패턴
  //      데이터를 가공하는 일은 그 데이터를 갖고 있는 클래스에 둬야 한다. 
  public String toCsvString() {
    return String.format("%s,%s,%s,%s",
        this.getName(),
        this.getEmail(),
        this.getTel(),
        this.getCompany());
  }
  @Override
  public String toString() {
    return "Contact [name=" + name + ", email=" + email + ", tel=" + tel + ", company=" + company
        + "]";
  }


  public String getName() {
    return name;
  }


  public void setName(String name) {
    this.name = name;
  }


  public String getEmail() {
    return email;
  }


  public void setEmail(String email) {
    this.email = email;
  }


  public String getTel() {
    return tel;
  }


  public void setTel(String tel) {
    this.tel = tel;
  }


  public String getCompany() {
    return company;
  }


  public void setCompany(String company) {
    this.company = company;
  }

}
