package com.moais.todolist.domain.todolist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class TodolistService {


    @Autowired
    private TodolistMapper todolistMapper;

    public void regist(Todolist todolist){
        todolistMapper.regist(todolist);
    };

    public Todolist findOne(String loginId) {
        return todolistMapper.findOne(loginId);
    }

    public List<Todolist> findAll(String loginId) {
        return todolistMapper.findAll(loginId);
    }

    public void update(Todolist todolist) {
        todolistMapper.update(todolist);
    }
}
