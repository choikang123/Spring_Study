package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {
    // 초기화 동시에 의존성 주입
    private final MemberRepository memberRepository;
    /*회원가입하고 id로 반환받는 이유 Member가 아니라 <궁금점 발생>
    * 사용자가 회원 가입 후 다양한 작업을 수행해야 할 필요성이 있을 때 유용
    * 하지만 코드의 복잡성이 올라갈 수 있음으로 저장을 하는 용도로만 쓰인다면 id 반환이 좋음
    * */

    // 쓰기에는 readonly=false로 설정 기본값
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member); // 중복 회원검증
        memberRepository.save(member);
        return member.getId();
    }

    public Member findMember(Long id) {
        return memberRepository.findOne(id);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 중복 이름이 있는지 확인
    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (findMembers.size()>0){
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

}

