package helloo.servlet.web.frontcontroller.v3.controller;

import helloo.servlet.domain.member.Member;
import helloo.servlet.domain.member.MemberRepository;
import helloo.servlet.web.frontcontroller.ModelView;
import helloo.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {
   private MemberRepository memberRepository = MemberRepository.getInstance();
    @Override
    public ModelView process(Map<String, String> paramMap) {
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        ModelView mv = new ModelView("save-result");
        mv.getModel().put("name", member);
        return mv;
    }
}
