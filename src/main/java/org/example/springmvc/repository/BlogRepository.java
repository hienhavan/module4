package org.example.springmvc.repository;

import org.example.springmvc.model.bai6_7.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.data.domain.Pageable;



@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {
    Page<Blog> findByTitleContainingIgnoreCase(String query, Pageable pageable);
    @Modifying
    @Transactional
    @Query("UPDATE Blog b SET b.title = :title, b.content = :content, b.author = :author, b.createdAt = :createdAt WHERE b.blogID = :id")
    void updateBlog(@Param("title") String title,
                    @Param("content") String content,
                    @Param("author") String author,
                    @Param("createdAt") String createdAt,
                    @Param("id") int id);
}
