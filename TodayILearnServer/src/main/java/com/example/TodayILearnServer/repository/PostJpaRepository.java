package com.example.TodayILearnServer.repository;

import com.example.TodayILearnServer.common.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJpaRepository extends JpaRepository<Post, Long> {
}
