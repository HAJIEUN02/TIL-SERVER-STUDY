package com.example.TodayILearnServer.dto.response;

import com.example.TodayILearnServer.common.entity.Member;
import com.example.TodayILearnServer.common.entity.SOPT;

public record MemberGetResponse (
        String name,
        String nickname,
        int age,
        SOPT soptInfo
) { // 사용자 정보를 응답하는 API
    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}