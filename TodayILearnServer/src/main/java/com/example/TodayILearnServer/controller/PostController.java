package com.example.TodayILearnServer.controller;

import com.example.TodayILearnServer.common.entity.Post;
import com.example.TodayILearnServer.dto.request.PostCreateRequest;
import com.example.TodayILearnServer.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    // Request Header로 받아올 member id
    private static final String CUSTOM_AUTH_ID = "X-Auth-ID";
    private final PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId, @RequestBody PostCreateRequest request) {
        URI location = URI.create("/api/post/" + postService.create(request, memberId));
        return ResponseEntity.created(location).build();
    }
}
