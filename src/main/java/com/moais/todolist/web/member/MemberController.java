package com.moais.todolist.web.member;

import com.moais.todolist.domain.member.MemberService;
import com.moais.todolist.domain.member.Member;

import com.moais.todolist.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") Member member){
        return "members/addMemberForm";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute Member member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "members/addMemberForm";
        }

        memberService.save(member);
        return "redirect:/";
    }

    @GetMapping("/signOut")
    public String signOut(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        Member loginSession = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        memberService.signOut(loginSession.getLoginId());
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

}
