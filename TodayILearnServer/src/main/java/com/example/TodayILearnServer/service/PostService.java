package com.example.TodayILearnServer.service;

import com.example.TodayILearnServer.common.entity.Member;
import com.example.TodayILearnServer.common.entity.Post;
import com.example.TodayILearnServer.dto.request.PostCreateRequest;
import com.example.TodayILearnServer.repository.MemberJpaRepository;
import com.example.TodayILearnServer.repository.PostJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostJpaRepository postJpaRepository;
    private final MemberJpaRepository memberJpaRepository;

    @Transactional
    public String create(PostCreateRequest request, Long memberId) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        Post post = postJpaRepository.save(
                Post.builder()
                        .member(member)
                        .title(request.title())
                        .content(request.content()).build()
        );
        return post.getPostId().toString();
    }
}
