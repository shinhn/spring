package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // test에 @Transactional이 되어 있으면 자동적으로 롤백
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    EntityManager em;

    @Test
    // @Rollback(false) // 롤백 안하고 바로 커밋 (test에 @Transactional이 되어 있으면 자동적으로 롤백을 하기 때문에 롤백 false를 해줘야 db에서 반영된 결과를 확인할 수 있음.)
    public void 회원가입() throws Exception{
        // given
        Member member = new Member();
        member.setName("kim");

        // when
        Long saveId = memberService.join(member);

        // then
        em.flush(); // em.flush()를 이용하면 쿼리를 날리기 때문에 insert문을 확인할 수 있음 (@Rollback(false)를 안해주면 롤백되어 db에는 반영안됨)
        assertEquals(member, memberRepository.findOne(saveId));

    }

    @Test(expected = IllegalStateException.class)
    public void 중복_회원_예외() throws Exception{
        // given
        Member member1 = new Member();
        member1.setName("Kim");

        Member member2 = new Member();
        member2.setName("Kim");

        // when
        memberService.join(member1);
        memberService.join(member2);

        // then
        fail("예외가 발생해야 한다."); // test에서 fail로 오면 안됨 (fail 문구가 나왔다면 위에서 뭔가 잘못된것)

    }

}