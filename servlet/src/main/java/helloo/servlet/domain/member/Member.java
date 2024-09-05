package helloo.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String username;
    private int age;
    private Long id;

    public Member(String name, int age) {
        this.username = name;
        this.age = age;
    }

}
