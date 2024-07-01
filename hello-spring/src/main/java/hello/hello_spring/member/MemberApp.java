package hello.hello_spring.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member member = new Member(1L, "choi", Grade.VIP);
        memberService.join(member);

        Member result = memberService.findMember(member.getId());
        System.out.println(result.getName());

    }
}
