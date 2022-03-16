package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Todo;

@Mapper
public interface TodoDao {

  int countAll();

  List<Todo> findAll();

  int insert(Todo todo) throws Exception;

  List<Todo> findByNo(int no);

  int update(Todo todo);

  int updateDone(boolean done);

  int delete(int no);
}











