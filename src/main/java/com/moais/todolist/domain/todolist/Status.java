package com.moais.todolist.domain.todolist;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Status {

    private String code;

    private String displayName;
}
