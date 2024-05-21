package com.example.TodayILearnServer.repository;

import com.example.TodayILearnServer.common.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {
    // JpaRepository<Entity, Entity의 식별자 타입> 형태로 작성한 후 상속해 사용
    default Member findByIdOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new IllegalStateException("Member with id " + id + " not found")
        );
    }
}
