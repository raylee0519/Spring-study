package springstudy.studyspring.controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springstudy.studyspring.domain.Member;
import springstudy.studyspring.service.MemberService;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberService;
    // @Autowired private MemberService memberService; //필드 주입 (선호하지 않음)
    // setter주입도 존재. 누군가 멤버 컨트롤 요청할때 public 노출이 되므로 위험함.

    @Autowired //생성자 주입
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        System.out.println("member = "+member.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }
}
