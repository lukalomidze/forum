package pt.ipcbcampus.lukalomidze.forum.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;

import lombok.Data;

@Data
@Container
public class Post {
    @Id
    @GeneratedValue
    private String id;
    private String author;
    private String content;
    private String imageUrl;
    private LocalDateTime creationTime;
}
