package springstudy.studyspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import springstudy.studyspring.domain.Member;
import springstudy.studyspring.service.MemberService;
import org.springframework.stereotype.Controller;

public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
