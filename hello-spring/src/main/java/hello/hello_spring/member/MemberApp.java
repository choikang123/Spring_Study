package hello.hello_spring.member;

import hello.hello_spring.order.AppConfig;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        Member member = new Member(1L, "choi", Grade.VIP);
        memberService.join(member);

        Member result = memberService.findMember(member.getId());
        System.out.println(result.getName());

    }
}
