package hello.hello_spring;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class HelloSpringApplicationTests {

	@Test
	void contextLoads() {
	}
	//Caused by: org.springframework.beans.factory.NoUniqueBeanDefinitionException:
	// No qualifying bean of type 'hello.hello_spring.member.MemberRepository' available: expected single matching bean but found 2: memoryMemberRepository,memberRepository
	// 오류 나는 이유 해결책 아직 잘 모르겠음
	// <문제 해결>
	// MemberRepository 타입의 빈을 주입해야 하는 곳에서 appconfig의 bean중에 memberRepository와 memoryMemberRepository가
	// 같은 타입의 빈이기 때문에 충돌이 났었음 그래서 @primary를 통해 우선권을 정해줘서 해결함
}
