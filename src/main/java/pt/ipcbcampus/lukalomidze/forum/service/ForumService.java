package pt.ipcbcampus.lukalomidze.forum.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pt.ipcbcampus.lukalomidze.forum.dto.CreatePostDTO;
import pt.ipcbcampus.lukalomidze.forum.dto.PostDTO;
import pt.ipcbcampus.lukalomidze.forum.entity.Post;
import pt.ipcbcampus.lukalomidze.forum.repository.PostRepository;

@Service
public class ForumService {

    @Autowired
    private AzureStorageService azureStorageService;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void createPost(CreatePostDTO postDTO) throws IOException {
        String imageUrl = azureStorageService.uploadBlob(postDTO.getImage());
        
        Post post = modelMapper.map(postDTO, Post.class);

        post.setImageUrl(imageUrl);

        postRepository.save(post);
    }

    public List<PostDTO> getAllPosts() {
        var posts = postRepository.findAll();

        return posts.stream()
            .map(post -> modelMapper.map(post, PostDTO.class))
        .collect(Collectors.toList());
    }
}
