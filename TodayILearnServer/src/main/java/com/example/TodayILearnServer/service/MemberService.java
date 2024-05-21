package com.example.TodayILearnServer.service;

import com.example.TodayILearnServer.common.entity.Member;
import com.example.TodayILearnServer.common.entity.SOPT;
import com.example.TodayILearnServer.dto.request.MemberCreateRequest;
import com.example.TodayILearnServer.dto.request.MemberProfileUpdateRequest;
import com.example.TodayILearnServer.dto.response.MemberGetResponse;
import com.example.TodayILearnServer.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberJpaRepository memberJpaRepository; // 의존성 주입

    // 사용자 조회 API
    /* BAD
    findById.get()으로 데이터를 가져오는 경우 NullPointerException 발생 위험
    1. MemberJpaRepository interface에서 findByIdOrThrow method 구현을 통해 활용
    2. MemberService 내부에 private method 만드는 방법
     */
    public MemberGetResponse getMemberByIdV1(Long id) {
        Member member = memberJpaRepository.findById(id).get();
        return MemberGetResponse.of(member);
    }

    // GOOD - NullPointerException 예외 처리
    public MemberGetResponse getMemberByIdV2(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("존재하지 않는 회원입니다.")));
    }

    // GOOD - MemberService 내부에 private method 만들어 활용
    public MemberGetResponse getMemberByIdV3(Long memberId) {
        return MemberGetResponse.of(findById(memberId));
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다.")
        );
    }

    // GOOD - MemberJpaRepository interface에서 구현한 findByIdOrThrow method 활용
    public MemberGetResponse getMemberByIdV4(Long id) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(id));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
                .stream()
                .map(MemberGetResponse::of)
                .collect(Collectors.toList());
    }

    // 사용자 생성 API
    @Transactional
    public String create(MemberCreateRequest request) {
        Member member = memberJpaRepository.save(Member.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .age(request.getAge())
                .sopt(request.getSopt())
                .build());
        return member.getId().toString();
    }

    @Transactional
    public void updateSOPT(Long memberId, MemberProfileUpdateRequest request) {
        Member member = memberJpaRepository.findByIdOrThrow(memberId);
        member.updateSOPT(new SOPT(request.getGeneration(), request.getPart()));
    }
}
