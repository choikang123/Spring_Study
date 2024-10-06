package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {
    // 아래 두 과정을 거쳐 롬복으로 간결하게 표현가능
    // 불변성 보장 생성과 동시에 의존성 주입 또한 테스트에서도 용이
    private final EntityManager em;

    /*@PersistenceContext
    EntityManager em;*/

   /* @Autowired
    public MemberRepository(EntityManager em) {
        this.em = em;
    }*/

    // 회원 저장
    public void save(Member member) {
        em.persist(member);
    }

    // 회원 찾기 (회원 id 넣어서)
    public Member findOne(Long id) {
       return em.find(Member.class, id);
    }

    // 회원들 찾기
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
    // 이름으로 회원들 찾기
    /**
     * findByName을 Member로 반환 받지 않고 List로 반환받는 이유가 궁금했는데
     * 이름이 같은 회원이 여러명 존재할 수 있기 때문이다. 만약 Member로 반환 받으면 같은 이름의 한명만 반환 받기 때문
     */
  /*  public Member findByName(String name) {
       return (Member) em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name);
    }
*/

}
