package hello.hello_spring.order;

import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.member.Member;
import hello.hello_spring.member.MemberRepository;



public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memId,itemName,itemPrice,discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
