package com.example.TodayILearnServer.common.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "post") // JPA에서 @Entity를 달아둔 class는 DB Table에 매핑됨
public class Post { // 게시글 Entity
    // 외래키(FK)를 이용해 Table 간의 관계를 맺음.
    // FK가 있는 Entity가 연관관계의 주인
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    private String title;
    @Column(columnDefinition = "TEXT")
    private String content;

    // Many-to-One(다대일 관계) : 게시글 - 사용자
    // 지연 로딩, 엔티티를 실제 사용할 때 조회
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id") // name 속성으로 DB에 저장될 이름 지정
    private Member member;

    @Builder
    public Post(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
