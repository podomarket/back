package com.podomarket.comment.controller;

import com.podomarket.comment.repository.CommentRepository;
import com.podomarket.comment.service.CommentService;
import com.podomarket.dto.request.CommentRequsetDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{productId}/comments")
    public ResponseDto<?> postComment(@PathVariable Long productId, @RequestBody CommentRequsetDto commentRequsetDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.createComment(commentRequsetDto, userDetails, productId);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseDto<?> deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.removeComment(commentId,userDetails);
    }

    @PutMapping("/comments/{commentId}")
    public ResponseDto<?> updateComment(@PathVariable Long commentId, @RequestBody CommentRequsetDto commentRequsetDto, @AuthenticationPrincipal UserDetailsImpl userDetails){
        return commentService.updateComment(commentId,commentRequsetDto,userDetails);
    }
}
