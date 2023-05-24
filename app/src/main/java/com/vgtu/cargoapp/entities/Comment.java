package com.vgtu.cargoapp.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
@Data
public class Comment {
    private int id;
    private User author;
    private LocalDateTime createdDateTime;
    private String commentText;
    private List<Comment> replies;
    private Comment parentComment;
}
