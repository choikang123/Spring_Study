package helloo.servlet.domain.member;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Long seqeunce = 0L;
    private static Map<Long, Member> store = new HashMap<>();

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    private MemberRepository() {
    }

    public Member save(Member member) {
        member.setId(seqeunce++);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Member member) {
        store.get(member.getId());
        return member;
    }

    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    public void clearStore() {
        store.clear();
    }
}
