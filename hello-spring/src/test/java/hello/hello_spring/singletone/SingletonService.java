package hello.hello_spring.singletone;

import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import hello.hello_spring.order.AppConfig;
import hello.hello_spring.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class SingletonService {
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void setSingletonService() {
        SingletonPattern singletonService1 = SingletonPattern.getInstance();
        SingletonPattern singletonService2 = SingletonPattern.getInstance();

        System.out.println("singletonSer1 -> " + singletonService1);
        System.out.println("singletonSer2 -> " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memSer1 = "+memberService1);
        System.out.println("memSer2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }
}
