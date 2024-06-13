package pt.ipcbcampus.lukalomidze.forum.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PostDTO {
    @NotBlank
    private String author;
    @NotBlank
    private String content;
    private MultipartFile image;
}
