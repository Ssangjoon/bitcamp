package com.eomcs.mylist.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.eomcs.mylist.dao.MemberDao;
import com.eomcs.mylist.domain.Member;

@Service
public class DefaultMemberService {

  @Autowired
  MemberDao memberDao;

  public int add(Member member) {
    return memberDao.insert(null);
  }
}
