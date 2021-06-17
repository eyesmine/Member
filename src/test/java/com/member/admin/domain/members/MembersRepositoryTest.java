package com.member.admin.domain.members;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MembersRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanUp() {
        memberRepository.deleteAll();
    }

    @Test
    public void show_member() {
        // given
        String userId = "test";
        String pw = "1234!@#$";

        memberRepository.save(Members.builder().userId(userId).pw(pw).build());

        // when
        List<Members> memberList = memberRepository.findAll();

        // then
        Members members = memberList.get(0);
        assertThat(members.getId()).isEqualTo(userId);
        assertThat(members.getPw()).isEqualTo(pw);


    }

    @Test
    public void BaseTimeEntity_insert() {
        // given
        LocalDateTime now = LocalDateTime.of(2021,6,18,0,0,0);
        memberRepository.save(Members.builder()
                    .userId("test")
                    .pw("1234!@#$").build());

        // when
        List<Members> membersList = memberRepository.findAll();

        // then
        Members members = membersList.get(0);

        System.out.println(">>>>>>>>>>>> createdDate="+members.getCreateDate()+", modifiedDate="+members.getModifiedDate());

        assertThat(members.getCreateDate()).isAfter(now);
        assertThat(members.getModifiedDate()).isAfter(now);
    }
}
