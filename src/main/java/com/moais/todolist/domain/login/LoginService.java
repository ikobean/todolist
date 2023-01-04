package com.moais.todolist.domain.login;

import com.moais.todolist.domain.member.MemberService;
import com.moais.todolist.domain.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberService memberService;

    public Member login(String loginId, String password){
        return memberService.findByLoginId(loginId)
                .filter(x -> x.getPassword().equals(password))
                .orElse(null);

    }
}
