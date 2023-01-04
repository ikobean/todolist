package com.moais.todolist.domain.member;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class Member {

    private Long id;

    @NotEmpty
    private String loginId;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    private String joinDt;

    private String lastLoginDt;

    private String signOutYn;

    private String signOutDt;

}
