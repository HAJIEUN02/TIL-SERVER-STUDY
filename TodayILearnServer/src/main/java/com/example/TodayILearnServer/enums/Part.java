package com.example.TodayILearnServer.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Part {
    SERVER("서버"),
    WEB("웹"),
    ANDROID("안드로이드"),
    IOS("iOS"),
    PLAN("기획"),
    DESIGN("디자인");

    // final 필드는 초기값이 실행 중에 수정될 수 없는 값으로 객체마다 저장됨
    // 필드 선언 시 초기값 주거나, 생성자에서 줄 수 있음
    private final String name;
}
