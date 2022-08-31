package com.yjproject.overnight.repository;

import com.yjproject.overnight.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    public void saveMember() throws Exception{
        //given
        Member member = new Member();
        member.setName("testA");

        //when
        memberRepository.save(member);
        Member findOne = memberRepository.findOne(member.getId());

        //then
        Assertions.assertThat(findOne.getId()).isEqualTo(member.getId());
    }


}