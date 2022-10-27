package com.podomarket.comment.service;


import com.podomarket.comment.repository.CommentRepository;
import com.podomarket.dto.request.CommentRequsetDto;
import com.podomarket.dto.response.CommentResponseDto;
import com.podomarket.dto.response.ResponseDto;
import com.podomarket.entity.Comments;
import com.podomarket.entity.product.Products;
import com.podomarket.entity.user.Users;
import com.podomarket.product.repository.ProductRepository;
import com.podomarket.user.service.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;

    @Transactional
    public ResponseDto<?> createComment(CommentRequsetDto commentRequsetDto, UserDetailsImpl userDetails, Long postId) {
        Products products = productRepository.findById(postId).orElseThrow(
                () -> new IllegalArgumentException("상품 관련 글이 없습니다.")
        );
        Users user = userDetails.getUser();
        Comments comments = new Comments(commentRequsetDto, user,products);
        commentRepository.save(comments);
        return ResponseDto.success("성공적으로 등록하셨습니다.");
    }

    @Transactional
    public ResponseDto<?> removeComment(Long id, UserDetailsImpl userDetails) {
        Comments comments = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다.")
        );
        try{
            if(userDetails.getUser().getUsername().equals(comments.getUser().getUsername())) {
                commentRepository.deleteById(id);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("본인이 아닙니다.");
        }
        return ResponseDto.success("성공적으로 삭제하였습니다.");
    }
    @Transactional
    public ResponseDto<?> updateComment(Long id, CommentRequsetDto commentRequsetDto, UserDetailsImpl userDetails) {

        Comments comments = commentRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("댓글이 없습니다.")
        );
        try{
            if(userDetails.getUser().getUsername().equals(comments.getUser().getUsername())) {
                comments.update(commentRequsetDto,userDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("본인이 아닙니다.");
        }
        CommentResponseDto commentResponseDto =new CommentResponseDto(comments);
        return ResponseDto.success(commentResponseDto);

    }
}





