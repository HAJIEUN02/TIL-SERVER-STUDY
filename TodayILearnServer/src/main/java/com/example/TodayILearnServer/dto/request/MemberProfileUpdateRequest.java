package com.example.TodayILearnServer.dto.request;

import com.example.TodayILearnServer.enums.Part;
import lombok.Data;

@Data
public class MemberProfileUpdateRequest { // 사용자의 SOPT 정보를 수정하는 API
    private int generation;
    private Part part;
}
