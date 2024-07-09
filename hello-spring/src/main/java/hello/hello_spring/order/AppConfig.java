package hello.hello_spring.order;

import hello.hello_spring.discount.FixDiscountPolicy;
import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import hello.hello_spring.member.MeomoryMemberRepository;

public class AppConfig {
    public MemberService memberService() {
        return new MemberServiceImpl(memoryRepository());
    }

    private static MeomoryMemberRepository memoryRepository() {
        return new MeomoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memoryRepository(), discountPolicy());
    }

    private static FixDiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}

