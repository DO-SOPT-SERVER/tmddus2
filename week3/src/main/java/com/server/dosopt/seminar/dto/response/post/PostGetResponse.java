package com.server.dosopt.seminar.dto.response.post;

import com.server.dosopt.seminar.domain.Category;
import com.server.dosopt.seminar.domain.CategoryId;
import com.server.dosopt.seminar.domain.Post;

public record PostGetResponse(
        Long id,
        String title,
        String content,
        String category
) {
    public static PostGetResponse of(Post post, Category category) {
        return new PostGetResponse(
                post.getPostId(),
                post.getTitle(),
                post.getContent(),
                category.getContent()
        );
    }
}
