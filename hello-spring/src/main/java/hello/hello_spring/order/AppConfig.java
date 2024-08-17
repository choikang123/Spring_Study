package hello.hello_spring.order;

import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.discount.RateDiscountPolicy;
import hello.hello_spring.member.MemberRepository;
import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import hello.hello_spring.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

