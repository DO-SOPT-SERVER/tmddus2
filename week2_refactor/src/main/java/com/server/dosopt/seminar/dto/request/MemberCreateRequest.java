package com.server.dosopt.seminar.dto.request;

import com.server.dosopt.seminar.domain.SOPT;

public record MemberCreateRequest(
        String name,
        String nickname,
        int age,
        SOPT sopt
) {

}