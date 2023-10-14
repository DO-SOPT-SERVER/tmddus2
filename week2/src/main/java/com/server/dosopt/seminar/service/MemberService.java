package com.server.dosopt.seminar.service;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.dto.request.MemberCreateRequest;
import com.server.dosopt.seminar.dto.response.MemberGetResponse;
import com.server.dosopt.seminar.repository.MemberJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberJpaRepository memberJpaRepository;

    public MemberGetResponse getByIdV1(Long memberId) {
        Member member = memberJpaRepository.findById(memberId).get();
        return MemberGetResponse.of(member);
    }

    public MemberGetResponse getByIdV2(Long memberId) {
        return MemberGetResponse.of(memberJpaRepository.findByIdOrThrow(memberId));
    }

    public List<MemberGetResponse> getMembers() {
        return memberJpaRepository.findAll()
            .stream()
            .map(MemberGetResponse::of)
            .collect(Collectors.toList());
    }

    @Transactional
    public String create(MemberCreateRequest request) {
        Member member = Member.builder()
                .name(request.name())
                .nickname(request.nickname())
                .age(request.age())
                .sopt(request.sopt())
                .build();
        return memberJpaRepository.save(member).getId().toString();
    }

    private Member findById(Long memberId) {
        return memberJpaRepository.findById(memberId).orElseThrow(
                () -> new EntityNotFoundException("해당하는 회원이 없습니다.")
        );
    }
}
