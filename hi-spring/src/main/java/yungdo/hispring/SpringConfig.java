package yungdo.hispring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import yungdo.hispring.repository.MemberRepository;
import yungdo.hispring.repository.MemoryMemberRepository;
import yungdo.hispring.service.MemberService;

// 스프링빈 자바로 직접 등록하기
@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
