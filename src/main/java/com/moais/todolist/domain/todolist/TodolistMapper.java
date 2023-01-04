package com.moais.todolist.domain.todolist;
import java.util.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TodolistMapper {

    int regist(Todolist todolist);

    int modifyStatus();

    Todolist findOne(String loginId);

    List<Todolist> findAll(String loginId);

    void update(Todolist todolist);
}
