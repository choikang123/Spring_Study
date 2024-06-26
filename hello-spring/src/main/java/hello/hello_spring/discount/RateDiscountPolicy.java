package hello.hello_spring.discount;

import hello.hello_spring.member.Grade;
import hello.hello_spring.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountpercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountpercent / 100;
        } else {
            return 0;
        }
    }
}
