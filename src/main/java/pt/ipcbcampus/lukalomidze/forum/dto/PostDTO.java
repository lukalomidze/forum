package pt.ipcbcampus.lukalomidze.forum.dto;

import lombok.Data;

@Data
public class PostDTO {
    private String author;
    private String content;
    private String imageUrl;
}
