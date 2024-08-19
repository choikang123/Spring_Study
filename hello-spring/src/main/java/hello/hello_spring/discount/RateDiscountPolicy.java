package hello.hello_spring.discount;

import hello.hello_spring.annotation.MainDiscountPolicy;
import hello.hello_spring.member.Grade;
import hello.hello_spring.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
//@Qualifier("mainDiscountPolicy") // **글자를 잘못 치거나 오타가 나면 문제가 생김**
@MainDiscountPolicy
public class RateDiscountPolicy implements DiscountPolicy {
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
