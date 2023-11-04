package com.server.dosopt.seminar.controller;

import com.server.dosopt.seminar.dto.request.post.PostCreateRequest;
import com.server.dosopt.seminar.dto.response.post.PostGetResponse;
import com.server.dosopt.seminar.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private static final String CUSTOM_AUTH_ID = "X-Auth-Id";

    @GetMapping("{postId}")
    public ResponseEntity<PostGetResponse> getPostById(@PathVariable Long postId) {
        return ResponseEntity.ok(postService.getById(postId));
    }

    @GetMapping
    public  ResponseEntity<List<PostGetResponse>> getPosts(@RequestHeader(CUSTOM_AUTH_ID) Long memberId) {
        return ResponseEntity.ok(postService.getPosts(memberId));
    }

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestHeader(CUSTOM_AUTH_ID) Long memberId,
                                           @RequestBody PostCreateRequest request
    ) {
        String postId = postService.create(request, memberId);
        URI location = URI.create("/api/posts/" + postId);
        return ResponseEntity.created(location).build();
    }
}
