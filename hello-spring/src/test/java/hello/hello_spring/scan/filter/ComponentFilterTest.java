package hello.hello_spring.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterTest {
    @Test
    void filterTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ComponentAppConfigFilterTest.class);
        BeanA beanA = ac.getBean("beanA", BeanA.class);
        Assertions.assertThat(beanA).isNotNull();

        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> ac.getBean("beanB", BeanB.class));
    }

    @Configuration
    @ComponentScan(
            //includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            includeFilters = @Filter(classes = MyIncludeComponent.class), // 기본값이 annotation이기 때문에 생략가능
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    static class ComponentAppConfigFilterTest {
    }
    //  그러니까 이 static 클래스는 컴포넌트 스캔을 이용해 컴포넌트를 널고 제외한 예시를 들기위한 클래스로 보면 됨.
    // AUTOAppconfig 같은거임
}

