package pt.ipcbcampus.lukalomidze.forum.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PostDTO {
    private String author;
    private String content;
    private String imageUrl;
    private LocalDateTime creationTime;
}
