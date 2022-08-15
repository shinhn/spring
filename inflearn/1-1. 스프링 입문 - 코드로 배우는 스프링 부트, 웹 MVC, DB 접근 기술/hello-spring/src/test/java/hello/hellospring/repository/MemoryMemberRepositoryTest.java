package hello.hellospring.repository;

import hello.hellospring.Repository.MemoryMemberRepository;
import hello.hellospring.domain.Member;

import hello.hellospring.service.MemberService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save(){
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        memberRepository.save(member);

        //then
        Member result = memberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member); // Assertions.assertEquals(member, result);
    }

    @Test
    public void findByName(){
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memberRepository.save(member2);

         //when
        Member result = memberRepository.findByName("spring1").get();

        // then
        assertThat(result).isEqualTo(member1);
    }
}
