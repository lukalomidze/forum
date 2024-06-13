package pt.ipcbcampus.lukalomidze.forum.service;

import java.io.IOException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void createPost(PostDTO postDTO) throws IOException {
        String imageUrl = azureStorageService.uploadBlob(postDTO.getImage());
        
        Post post = modelMapper.map(postDTO, Post.class);

        post.setImageUrl(imageUrl);

        postRepository.save(post);
    }
}
