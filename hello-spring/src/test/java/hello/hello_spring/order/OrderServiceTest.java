package hello.hello_spring.order;

import hello.hello_spring.member.Grade;
import hello.hello_spring.member.Member;
import hello.hello_spring.member.MemberService;
import hello.hello_spring.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();
    MemberService memberService = new MemberServiceImpl();

    @Test
    void createOrder() {
        Long memId = 1L;
        Member member = new Member(memId, "choi", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
