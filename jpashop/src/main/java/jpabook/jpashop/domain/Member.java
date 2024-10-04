package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member { // 테이블에는 member 소문자로 들어가게 됨 관례에 의해서
    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded // 내장 값으로 쓸 때
    private Address address;

    @OneToMany(mappedBy = "member") // 주문은 멤버와의 관계에서 N
    private List<Order> orders = new ArrayList<>();
}
