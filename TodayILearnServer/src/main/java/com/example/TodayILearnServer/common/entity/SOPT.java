package com.example.TodayILearnServer.common.entity;

import com.example.TodayILearnServer.enums.Part;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Enumerated;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static jakarta.persistence.EnumType.STRING;

@Embeddable // @Embedded로 들어갈 class에 붙이는 코드
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class SOPT {
    private int generation;

    @Enumerated(value = STRING) // 지정하지 않을 경우 Enum 값이 아닌 인덱스 값으로 DB에 저장됨
    private Part part;
}
