package org.example.springmvc.services.bai6_7;

import org.example.springmvc.model.bai6_7.Blog;
import org.example.springmvc.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;

    public Page<Blog> blogList(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    public Page<Blog> searchBlogs(String query, Pageable pageable) {
        return blogRepository.findByTitleContainingIgnoreCase(query, pageable);
    }

    public void saveBlog(Blog blog) {
        blogRepository.save(blog);
    }

    public Blog getBlogById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    public void deleteBlog(int id) {
        blogRepository.deleteById(id);
    }
}
