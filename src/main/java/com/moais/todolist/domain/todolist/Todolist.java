package com.moais.todolist.domain.todolist;

import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class Todolist {
    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String content;

    private String status;

    private String firstRegistDt;

    private String lastModifyDt;





}
