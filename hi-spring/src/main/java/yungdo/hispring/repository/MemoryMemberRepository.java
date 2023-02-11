package yungdo.hispring.repository;

import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;
import yungdo.hispring.domain.Member;

import java.util.*;


@Repository
public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) { //store에서 꺼낸다
        return Optional.ofNullable(store.get(id)); // null값을 감싸서 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name)) //파라미터로 넘어온 네임이 getName과 같은지 확인하는 람다 함수. 같은경우 필터링
                .findAny(); // 찾으면 반환, 끝까지 없으면 optional에 null이 포함되어 반환
    }

    public void clearStore() {
        store.clear();
    }
}
