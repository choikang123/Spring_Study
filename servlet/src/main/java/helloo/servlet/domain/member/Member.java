package helloo.servlet.domain.member;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Member {
    private String name;
    private int age;
    private Long id;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
