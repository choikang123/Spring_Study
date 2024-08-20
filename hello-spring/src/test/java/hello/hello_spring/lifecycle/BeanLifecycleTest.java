package hello.hello_spring.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;

public class BeanLifecycleTest {
    @Test
    void beanCycleTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient networkClient = ac.getBean(NetworkClient.class);
        ac.close();
    }

    @Configuration
    static class LifeCycleConfig {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }

}
