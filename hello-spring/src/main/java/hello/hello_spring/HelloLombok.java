package hello.hello_spring;

import lombok.Getter;
import lombok.Lombok;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setAge(20);
        int age = helloLombok.getAge();
        System.out.println("age = " + age);
    }
}
