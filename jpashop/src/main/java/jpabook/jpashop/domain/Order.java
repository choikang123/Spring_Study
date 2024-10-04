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
}
