package com.server.dosopt.seminar.dto.response;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.domain.SOPT;
import lombok.Data;

public record MemberGetResponse(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {
    public MemberGetResponse(Member member) {
        this(member.getName(), member.getNickname(), member.getAge(), member.getSopt());
    }

}