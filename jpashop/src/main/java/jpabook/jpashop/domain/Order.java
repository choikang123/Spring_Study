package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity @Getter @Setter
@Table(name = "orders") // orders로 쓰는 이유는 sql명령어 `order by`와 충돌을 방지 하기 위함
public class Order {
    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // 성능 최적화를 위해 -ToOne으로 끝나는 관계는 지연로딩 적용
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order" , cascade = CascadeType.ALL)
    //cascade 부모 엔티티에 대한 작업을 자식 엔티티에게도 전파하는 방식 sql의 cascade 생각하면 됨
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate; // 주문시간

    @Enumerated(EnumType.STRING) // 1,2 숫자가 아닌 글자로 되도록 EnumType은 string으로
    private OrderStatus orderStatus; // 주문상태


//    public static void main(String[] args) {
//        Member member = new Member();
//        Order order = new Order();
//        member.getOrders().add(order); // member가 order 설정
//        order.setMember(member); // order가 member 설정
//    }

    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
        // 이 코드를 통해 한번에 양방향 연관관계를 맺어줌
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    } // 양방향 관계 맺어주기 order와 orderItem

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrder(this);
    }

    // 생성 메서드
    public Order createOrder(Member member, Delivery delivery, OrderItem... orderItems) {
        Order order = new Order();
        order.setMember(member); // 양방향 관계설정
        order.setDelivery(delivery); // 양방향 관계설정
        for (OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        } // 양방향 관계설정
        order.setOrderStatus(OrderStatus.ORDER); //주문상태로 변경
        order.setOrderDate(LocalDateTime.now()); //주문시간 설정
        return order; // 초기화한 주문 반환
    }

    // 비즈니스 로직
    public void cancle() { // 주문 취소 했을때
        if (delivery.getStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("배달완료된 상품은 취소할 수 없습니다");
        } //만약 배달이 완료된 상태라면 예외 터트리기
        // 주문 취소 했으면 수량 맞춰야지 어떻게? 주문한 수량만큼 원래 수량에 더해주기
        this.setOrderStatus(OrderStatus.CANCLE);
        for (OrderItem orderItem : orderItems) {
            /*orderItem.getItem().addStock();*/ //
            // addStock()에 주문수량 바로 넣어줘애 되는데, 주문 수량은 orderItem에 있음!
            // 어떤 함수?
            orderItem.cancle();
        }
    }

    // 조회 로직
    public int getTotalPrice() {
        int totalPrice = 0;
        for (OrderItem orderItem : orderItems) {
            totalPrice += orderItem.getTotalprice();
        }
        return totalPrice;
    }

    //
}
