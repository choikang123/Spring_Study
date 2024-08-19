package hello.hello_spring.order;

import hello.hello_spring.annotation.MainDiscountPolicy;
import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.member.Member;
import hello.hello_spring.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository,@MainDiscountPolicy DiscountPolicy rateDiscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = rateDiscountPolicy; //
    }

    @Override
    public Order createOrder(Long memId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memId,itemName,itemPrice,discountPrice);
    }

    // 수정자 주입 방법
    /*public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
    */
    // 필드 주입 방법
    /*@Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DiscountPolicy discountPolicy;*/

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
