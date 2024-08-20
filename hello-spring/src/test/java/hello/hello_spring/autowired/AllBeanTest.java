package hello.hello_spring.autowired;

import hello.hello_spring.AutoAppConfig;
import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.member.Grade;
import hello.hello_spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllBeanTest {
    @Test
    void findAllBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(DiscountService.class, AutoAppConfig.class);
        DiscountService discountService = ac.getBean(DiscountService.class);

        Member choi = new Member(1L, "choi", Grade.VIP);
        int discountPrice = discountService.discountChoice(choi, 10000, "fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    static class DiscountService{
        private final Map<String, DiscountPolicy> policyMap;
        @Autowired
        DiscountService(Map<String, DiscountPolicy> policyMap) {
            this.policyMap = policyMap;
            System.out.println("policyMap = " + policyMap);
        }

        public int discountChoice(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
