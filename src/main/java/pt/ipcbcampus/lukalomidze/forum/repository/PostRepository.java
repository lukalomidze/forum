package pt.ipcbcampus.lukalomidze.forum.repository;

import org.springframework.stereotype.Repository;

import com.azure.spring.data.cosmos.repository.CosmosRepository;

import pt.ipcbcampus.lukalomidze.forum.entity.Post;

@Repository
public interface PostRepository extends CosmosRepository<Post, String> {
    public Iterable<Post> findAllByOrderByCreationTimeDesc();
}
