package pt.ipcbcampus.lukalomidze.forum.entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Post {
    @Id
    private String id;
    private String author;
    private String content;
    private String imageUrl;
}
