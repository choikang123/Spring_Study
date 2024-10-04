package jpabook.jpashop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    // @Id는 해당 필드가 데이터베이스 테이블의 기본 키(primary key)임을 나타냅니다.
    // @GeneratedValue는 id 필드가 자동으로 값이 생성된다는 것을 나타냅니다.
    //보통 데이터베이스에서 자동 증가되는 방식(예: MySQL의 AUTO_INCREMENT)을 사용해 id 값이 자동으로 생성됩니다.
    private Long id;
    private String username;

}
