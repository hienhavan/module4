package org.example.springmvc.homecontroller.bai6_7;

import org.example.springmvc.model.bai6_7.Blog;
import org.example.springmvc.repository.BlogRepository;
import org.example.springmvc.services.bai6_7.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class ControllerBlog {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping("/showBlog")
    public ModelAndView showBlog(@RequestParam(defaultValue = "3") int page,
                                 @RequestParam(defaultValue = "3") int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "createdAt"));
        Page<Blog> blogPage = blogService.blogList(pageable);

        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogs", blogPage.getContent());
        modelAndView.addObject("currentPage", blogPage.getNumber());
        modelAndView.addObject("totalPages", blogPage.getTotalPages());
        modelAndView.addObject("size", size);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteBlog(@PathVariable("id") int id) {
        blogService.deleteBlog(id);
        return "redirect:/blog/showBlog";
    }

    @GetMapping("/formAdd")
    public ModelAndView formAddBlog() {
        ModelAndView modelAndView = new ModelAndView("addBlog");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/addBlog")
    public String addBlog(@ModelAttribute Blog blog) {
        blogService.saveBlog(blog);
        return "redirect:/blog/showBlog";
    }

    @GetMapping("/formEdit/{id}")
    public ModelAndView formEditBlog(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("editBlog");
        modelAndView.addObject("blog", blogService.getBlogById(id));
        return modelAndView;
    }

    @PostMapping("/formEdit/editBlog/{id}")
    public String editBlog(@ModelAttribute Blog blog, @PathVariable("id") int id) {
        blogRepository.updateBlog(blog.getTitle(), blog.getContent(), blog.getAuthor(), blog.getCreatedAt(), id);
        return "redirect:/blog/showBlog";
    }
    @GetMapping("/search")
    public ModelAndView searchBlogs(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        Page<Blog> blogPage = blogService.searchBlogs(query, PageRequest.of(page, size,Sort.by(Sort.Direction.ASC,"createdAt")));
        ModelAndView modelAndView = new ModelAndView("listBlog");
        modelAndView.addObject("blogs", blogPage.getContent());
        modelAndView.addObject("currentPage", blogPage.getNumber());
        modelAndView.addObject("totalPages", blogPage.getTotalPages());
        modelAndView.addObject("size", size);
        modelAndView.addObject("query", query);
        return modelAndView;
    }

}
