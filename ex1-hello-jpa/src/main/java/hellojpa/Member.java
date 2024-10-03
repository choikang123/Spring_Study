package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity // jpa를 사용하는 애구나라고 인식하는 애노테이션
public class Member {
    @Id // 자바에게 키값을 알려주는
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10, name = "username")
    private String name;

    public Member() {
    }

}
