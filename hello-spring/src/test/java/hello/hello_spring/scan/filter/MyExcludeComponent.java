package hello.hello_spring.scan.filter;


import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    //얘가 붙은건 컴포넌트 스캔에 넣겠다는 거
}
