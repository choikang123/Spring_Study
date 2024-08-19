package hello.hello_spring.order;

import hello.hello_spring.discount.FixDiscountPolicy;
import hello.hello_spring.member.Grade;
import hello.hello_spring.member.Member;
import hello.hello_spring.member.MemberRepository;
import hello.hello_spring.member.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {

        MemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "name", Grade.VIP));
        OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
        Order order1 = orderService.createOrder(1L, "itemA", 10000);
        Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);

        //생성자로 주입을 선택했기 때문에 임의로 순수한 자바로 테스트를 만들때 생성자에 원하는 객체를 생성해서 넣어야하는 규약이 생김
        //생성자 주입은 final 키워드를 넣어줄 수 있음
        // 생성자 주입을 통해 누락 오류도 잡아낼 수 있음
    }

}