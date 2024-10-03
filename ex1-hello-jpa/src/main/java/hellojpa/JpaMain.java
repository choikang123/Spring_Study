package hellojpa;

import domain2.Member;
import domain2.Team;
import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        //EntityManagerFactory 엔티티 로딩시점에 딱 하나만 있어야 한다
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin(); //트랜잭션 시작
        //code
        try {
            Team team = new Team();
            team.setName("team1");
            em.persist(team);

            Member member = new Member();
            member.setUsername("choi");
            em.persist(member);

            em.flush();
            em.clear();

            Member findMem = em.find(Member.class, member.getId());
            List<Member> members = findMem.getTeam().getMembers();
            for (Member m : members) {
                System.out.println("m.getUsername() = " + m.getUsername());
            }
            tx.commit(); // 트랜잭션 커밋
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
