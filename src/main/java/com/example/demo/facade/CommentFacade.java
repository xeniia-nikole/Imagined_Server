package com.example.demo.facade;

import com.example.demo.dataTransferObject.CommentDTO;
import com.example.demo.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentFacade {

    public CommentDTO commentToCommentDTO(Comment comment) {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setId(comment.getId());
        commentDTO.setUsername(comment.getAuthor());
        commentDTO.setMessage(comment.getContent());

        return commentDTO;
    }

}
