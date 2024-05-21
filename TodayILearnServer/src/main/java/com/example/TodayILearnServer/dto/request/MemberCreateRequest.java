package com.example.TodayILearnServer.dto.request;

import com.example.TodayILearnServer.common.entity.SOPT;
import lombok.Data;

@Data
public class MemberCreateRequest { // Member 생성 API
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;
}
