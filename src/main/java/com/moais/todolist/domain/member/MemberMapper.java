package com.moais.todolist.domain.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Mapper
@Repository
public interface MemberMapper {

    int save(Member member);
    Member findById(String loginId);

    Optional<Member> findByLoginId(String loginId);

    void signOut(String loginId);
}
