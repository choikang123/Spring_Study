package hello.hello_spring.discount;

import hello.hello_spring.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
