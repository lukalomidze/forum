package pt.ipcbcampus.lukalomidze.forum.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.validation.Valid;
import pt.ipcbcampus.lukalomidze.forum.dto.CreatePostDTO;
import pt.ipcbcampus.lukalomidze.forum.dto.PostDTO;
import pt.ipcbcampus.lukalomidze.forum.service.ForumService;
import org.springframework.web.bind.annotation.GetMapping;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @PostMapping("/create-post")
    public void createPost(
        @Valid CreatePostDTO postDTO
    ) {
        try {
            forumService.createPost(postDTO);
        } catch (IOException exception) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/get-all-posts")
    public List<PostDTO> getAllPosts() {
        return forumService.getAllPosts();
    }
    
}
