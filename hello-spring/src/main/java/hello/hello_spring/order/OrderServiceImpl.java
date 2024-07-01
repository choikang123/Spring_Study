package hello.hello_spring.order;

import hello.hello_spring.discount.DiscountPolicy;
import hello.hello_spring.member.Member;
import hello.hello_spring.member.MemberRepository;
import hello.hello_spring.member.MeomoryMemberRepository;


public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository = new MeomoryMemberRepository();
    private DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    @Override
    public Order createOrder(Long memId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memId,itemName,itemPrice,discountPrice);
    }
}
