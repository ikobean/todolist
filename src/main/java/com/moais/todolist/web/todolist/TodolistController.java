package com.moais.todolist.web.todolist;

import com.moais.todolist.domain.member.Member;
import com.moais.todolist.domain.todolist.Status;
import com.moais.todolist.domain.todolist.Todolist;
import com.moais.todolist.domain.todolist.TodolistService;
import com.moais.todolist.web.SessionConst;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;
@Controller
@RequestMapping("/to-do-list")
@RequiredArgsConstructor
@Slf4j
public class TodolistController {

    private final TodolistService todolistService;

    @GetMapping("/findOne")
    public String findOne(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "/login";
        }

        Member loginSession = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        Todolist todolist = todolistService.findOne(loginSession.getLoginId());
        model.addAttribute("todolist", todolist);
        model.addAttribute("statusList", getStatusList());
        return "content/todolist";
    }
    @GetMapping("/findAll")
    public String findAll(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        if(session == null){
            return "/login";
        }

        Member loginSession = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);
        List<Todolist> todolist = todolistService.findAll(loginSession.getLoginId());
        model.addAttribute("todolist", todolist);
        model.addAttribute("statusList", getStatusList());
        return "content/todolist";
    }

    @PostMapping("/regist")
    public @ResponseBody void regist(@RequestBody Todolist todolist, BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            bindingResult.reject("registFail", "에러가 발생하였습니다. 다음에 다시 시도해 주세요.");
        }
        HttpSession session = request.getSession(false);
        Member loginSession = (Member) session.getAttribute(SessionConst.LOGIN_MEMBER);

        log.info("todolist = {}", todolist);
        todolist.setLoginId(loginSession.getLoginId());
        todolistService.regist(todolist);
    }

    @PostMapping("/update")
    public @ResponseBody  void updateStatus(@RequestBody Todolist todolist, BindingResult bindingResult, HttpServletRequest request){
        if (bindingResult.hasErrors()) {
            bindingResult.reject("registFail", "에러가 발생하였습니다. 다음에 다시 시도해 주세요.");
        }
        todolistService.update(todolist);
    }

    public List<Status> getStatusList(){
        List<Status> statusList = new ArrayList<>();
        statusList.add(new Status("1", "할 일"));
        statusList.add(new Status("2", "진행 중"));
        statusList.add(new Status("3", "완료 됨"));
        return statusList;
    }



}