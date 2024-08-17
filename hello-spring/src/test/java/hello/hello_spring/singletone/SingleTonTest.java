package hello.hello_spring.singletone;

import hello.hello_spring.member.MemberService;
import hello.hello_spring.order.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingleTonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberservice1 -> " + memberService1);
        System.out.println("memberservice2 -> " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        // 객체를 각각 생성하기 때문에 다른 참조값이 나오게 됨.
        // 스프링을 이용한다면 싱글톤을 지킬 수 있을까? -> 가능
    }
}
