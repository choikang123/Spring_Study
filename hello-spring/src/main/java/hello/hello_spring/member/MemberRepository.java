package hello.hello_spring.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long id);
}
