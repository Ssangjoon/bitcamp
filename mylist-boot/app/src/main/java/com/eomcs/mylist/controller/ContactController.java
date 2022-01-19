package com.eomcs.mylist.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.util.ArrayList;

@RestController 
public class ContactController {

  ArrayList contactList = new ArrayList();

  public ContactController() throws Exception {
    System.out.println("ContactController() 호출됨!");
    try {
      ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("contacts.ser2")));

      //    while (true) {
      //      try {
      //        Contact contact = new Contact();
      //        contact.setName(in.readUTF());
      //        contact.setEmail(in.readUTF());
      //        contact.setTel(in.readUTF());
      //        contact.setCompany(in.readUTF());
      //
      //        contactList.add(contact);
      //      } catch (Exception e) {
      //        break;
      //      }
      //    }
      contactList = (ArrayList)in.readObject();

      in.close();
    } catch (Exception e) {
      System.out.println("컨택트 데이터를 로딩 하는 중 오류 발생");
    }}

  @RequestMapping("/contact/list")
  public Object list() {
    return contactList.toArray(); 
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact) {
    //    System.out.println(contact);
    contactList.add(contact);
    return contactList.size();
  }


  @RequestMapping("/contact/get")
  public Object get(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return "";
    }
    return contactList.get(index);
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact) {
    int index = indexOf(contact.getEmail());
    if (index == -1) {
      return 0;
    }

    return contactList.set(index, contact) == null ? 0 : 1;
  }

  @RequestMapping("/contact/delete")
  public Object delete(String email) {
    int index = indexOf(email);
    if (index == -1) {
      return 0;
    }

    contactList.remove(index);
    return 1;
  }

  @RequestMapping("/contact/save")
  public Object save() throws Exception {
    ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("contacts.ser2")));

    //    Object[] arr = contactList.toArray();
    //    for (Object obj : arr) {
    //      Contact contact = (Contact) obj;
    //      out.writeUTF(contact.getName());
    //      out.writeUTF(contact.getEmail());
    //      out.writeUTF(contact.getTel());
    //      out.writeUTF(contact.getCompany());
    //    }
    out.writeObject(contactList);

    out.close();
    return contactList.size();
  }

  int indexOf(String email) {
    for (int i = 0; i < contactList.size(); i++) {
      Contact contact =  (Contact) contactList.get(i);
      if (contact.getEmail().equals(email)) { 
        return i;
      }
    }
    return -1;
  }
}




