package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Contact;

@Mapper
public interface ContactDao {

  int countAll();

  List<Contact> findAll();

  int insert(Contact contact);

  List<Contact> findByEmail(String email);

  List<Contact> findByNo(int no);

  List<Contact> findByName(String name);

  int update(Contact contact)  ;

  int delete(int no)  ;
}











