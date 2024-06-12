package pt.ipcbcampus.lukalomidze.forum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import pt.ipcbcampus.lukalomidze.forum.entity.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
}
