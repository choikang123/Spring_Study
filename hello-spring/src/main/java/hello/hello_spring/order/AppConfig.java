package hello.hello_spring.order;

import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.discount.FixDiscountPolicy;
import hello.hello_spring.discount.RateDiscountPolicy;
import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import hello.hello_spring.member.MeomoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memoryRepository());
    }
    @Bean
    public static MeomoryMemberRepository memoryRepository() {
        return new MeomoryMemberRepository();
    }
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }
    @Bean
    public static DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}

