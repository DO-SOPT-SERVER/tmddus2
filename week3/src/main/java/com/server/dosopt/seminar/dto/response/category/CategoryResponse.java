package com.server.dosopt.seminar.dto.response.category;

import com.server.dosopt.seminar.domain.Category;
import com.server.dosopt.seminar.domain.Post;
public record CategoryResponse(
        Short id,
        String content
) {
    public static CategoryResponse of(Category category) {
        return new CategoryResponse(
                category.getId(),
                category.getContent()
        );
    }
}
