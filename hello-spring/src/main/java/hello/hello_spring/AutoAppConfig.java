package hello.hello_spring;

import hello.hello_spring.member.MemberRepository;
import hello.hello_spring.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class))
// 예제 활용을 위해 @Configuration이 붙은 클래스 제외
public class AutoAppConfig {

}
/*  @Bean(name = "memoryMemberRepository")
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }*/
// 수동 빈 등록과 컴포넌트로 자동 등록된 빈이 겹치면 수동빈이 자동빈을 오버라이딩 해버린다
// 그치만 버그가 나는 경우가 많아 스프링부트에서는 오류로 결과를 냄
