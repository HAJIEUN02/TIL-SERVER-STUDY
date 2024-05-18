package com.example.TodayILearnServer.dto.response;

import lombok.Data;

// API 응답 객체 정의
@Data // lombok으로 사용할 수 있는 Data 어노테이션(getter/setter, 기본 생성자, toString())
// 여기서는 @Getter만 사용해도 작동함.
public class HealthCheckResponse {
    private static final String STATUS = "OK";
    private String status;

    public HealthCheckResponse() {
        this.status = STATUS;
    }
}
