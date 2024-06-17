package pt.ipcbcampus.lukalomidze.forum.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.azure.spring.data.cosmos.core.mapping.Container;
import com.azure.spring.data.cosmos.core.mapping.GeneratedValue;
import com.fasterxml.jackson.annotation.JsonFormat;

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
    // Necessary as creationTime by default gets serialized as a
    // numerical array which messes up repository's creationTime
    // based sorting 
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime creationTime;
}
