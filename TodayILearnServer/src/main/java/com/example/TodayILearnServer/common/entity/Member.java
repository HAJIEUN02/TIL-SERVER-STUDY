package com.example.TodayILearnServer.common.entity;

import com.example.TodayILearnServer.domain.Post.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 기본 생성자 만들어주는 어노테이션
public class Member extends BaseTimeEntity {
    /*
    @Id는 해당 필드가 식별자임을 명시해주는 어노테이션으로,
    @Entity가 붙은 클래스에 반드시 선언되어야 함
    @GeneratedValue는 DB에 id를 어떻게 생성할지 전략을 나타내는 어노테이션
     */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String nickname;
    private int age;

    // CascadeType은 양방향 연관관계를 통해 맺어줄 수 있음
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private final List<Post> posts = new ArrayList<>();

    @Embedded
    private SOPT sopt;

    // 파라미터가 있는 생성자 정의
    @Builder // Builder 패턴을 이용해 객체를 생성
    public Member(String name, String nickname, int age, SOPT sopt) {
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.sopt = sopt;
    }

    public void updateSOPT(SOPT sopt) {
        this.sopt = sopt;
    }
}
