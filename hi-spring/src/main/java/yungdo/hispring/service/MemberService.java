// 비즈니스 메서드 만들기 (회원 서비스 개발)
package yungdo.hispring.service;

<<<<<<< HEAD
import yungdo.hispring.domain.Member;
import yungdo.hispring.repository.MemberRepository;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yungdo.hispring.domain.Member;
import yungdo.hispring.repository.MemberRepository;
import yungdo.hispring.repository.MemoryMemberRepository;
>>>>>>> 2319d258462015750ca0958984bee052abc92704

import java.util.List;
import java.util.Optional;

<<<<<<< HEAD

//@Service // 스프링 컨테이너에 서비스라고 등록해주는 역할 ( 비즈니스로직 )
=======
@Service // 스프링 컨테이너에 서비스라고 등록해주는 역할 ( 비즈니스로직 )
>>>>>>> 2319d258462015750ca0958984bee052abc92704
public class MemberService {

    private final MemberRepository memberRepository;

<<<<<<< HEAD
//    @Autowired // dependency injection
=======
    @Autowired // dependency injection
>>>>>>> 2319d258462015750ca0958984bee052abc92704
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 안된다면..
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()) // optional
                .ifPresent(m -> { // 값이 있으면(null이 아니면) -> optional이기 때문에 가능함
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
