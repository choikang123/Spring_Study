package hello.hello_spring.member;

import hello.hello_spring.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }
    @Test
    void join() {

        //given
        Member member = new Member(1L, "choi", Grade.VIP);

        //when
        memberService.join(member);
        Member findMem = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMem);
    }
}
