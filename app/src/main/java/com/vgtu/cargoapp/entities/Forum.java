package com.vgtu.cargoapp.entities;

import java.time.LocalDateTime;
import java.util.List;
public class Forum {
    private int id;
    private List<Forum> subforums;
    private LocalDateTime lastActivityDateTime;
    private List<Comment> comments;
}
