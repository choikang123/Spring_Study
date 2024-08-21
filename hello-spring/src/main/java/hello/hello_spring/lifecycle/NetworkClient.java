package hello.hello_spring.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class NetworkClient {
    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void call(String message) {
        System.out.println("call:"+url+" message:"+message);
    }

    //서비스 호출시 시작
    public void connect() {
        System.out.println("connect: "+url);
    }

    public void disconnect() {
        System.out.println("close:" + url);
    }

    @PostConstruct
    public void init() {
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메세지");
    }
    // 1. 빈 생성 -> 2.의존성 주입 -> 3. 초기화: 의존성 주입이 완료된 후 @postConstruct가 붙은 메서드가 호출
    // 이 시점에서 빈은 모든 의존성이 주입된 상태
    @PreDestroy
    public void close() {
        System.out.println("NetworkClient.close");
        disconnect();
    }
}
