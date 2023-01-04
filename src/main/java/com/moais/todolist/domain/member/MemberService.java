package com.moais.todolist.domain.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Slf4j
@Service
public class MemberService {

    @Autowired
    public MemberMapper memberMapper;

    private static Map<Long, Member> store = new HashMap<>();


    public int save(Member member){
        int result = memberMapper.save(member);
        return result;
    }

    public Member findById(Long id){
        return store.get(id);
    }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public Optional<Member> findByLoginId(String loginId){
        return memberMapper.findByLoginId(loginId);
    }

    public void signOut(String loginId) {
        memberMapper.signOut(loginId);
    }
}
