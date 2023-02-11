package yungdo.hispring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import yungdo.hispring.service.MemberService;

@Controller // 컨트롤러 : 외부 요청 받기
public class MemberController {

    private final MemberService memberService;

    // 인스턴스 여러게 만들지 않고 스프링 컨테이너에 하나만 등록하기
    @Autowired // dependency injection
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
