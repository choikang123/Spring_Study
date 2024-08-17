package hello.hello_spring.singletone;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletonPattern {
    private static final SingletonPattern instance = new SingletonPattern();

    private SingletonPattern() {

    }

    public static SingletonPattern getInstance() {
        return instance;
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

    // static 영역에 객체를 생성해서 static 메서드를 통해서만 인스턴스를 가져올 수 있게 하며, private 생성자를 통해
    // 외부에서 생성하지 못하도록 막음
    // 그러나 매번 싱글톤 패턴을 이용하고자 모든 객체에 이렇게 하기에는 부담이 된다
    // 그래서 이 역할을 대신 해주는게 스프링!
}
