package yungdo.hispring.service;
// ctrl + shift + T로 테스트 자동 생성
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yungdo.hispring.domain.Member;
import yungdo.hispring.repository.MemoryMemberRepository;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() { // Dependency Injection, DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach //메서드가 실행이 끝날때마다 실행되는 콜백 메서드, 테스트가 실행될때마다 store가 비워지면서 테스트 순서가 상관없게 됨(의존성이 없게 됨)
    public void afterEach(){
        memberRepository.clearStore();
    }
    @Test
    void 회원가입() { // 테스트 코드는 한글로 바꿔도됨
        //given : 주어진 상황
        Member member = new Member();
        member.setName("hello");

        //when : 검증할 것
        Long saveId = memberService.join(member);

        //then : 결과
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }

        //then

        }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}