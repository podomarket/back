package com.podomarket.dto.response;

import com.podomarket.entity.Comments;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentResponseDto {

    private String content;
    private String username;

    private Long id;

    public CommentResponseDto(Comments comments){
        this.content = comments.getContent();
        this.username = comments.getUser().getUsername();
        this.id = comments.getId();
    }
}
