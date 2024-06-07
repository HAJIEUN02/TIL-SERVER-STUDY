package com.example.TodayILearnServer.dto.request;

public record PostCreateRequest(
        String title,
        String content
) {
}