package com.server.dosopt.seminar.dto.response;

import com.server.dosopt.seminar.domain.Member;
import com.server.dosopt.seminar.domain.SOPT;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberGetResponse {
    private String name;
    private String nickname;
    private int age;
    private SOPT sopt;

    public static MemberGetResponse of(Member member) {
        return new MemberGetResponse(
                member.getName(),
                member.getNickname(),
                member.getAge(),
                member.getSopt()
        );
    }
}