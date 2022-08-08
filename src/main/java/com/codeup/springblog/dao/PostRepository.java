package com.codeup.springblog.dao;
import com.codeup.springblog.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long>{
}
