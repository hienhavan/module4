package org.example.springmvc.homecontroller.bai6_7_11_12;

import org.example.springmvc.model.bai6_7.Blog;
import org.example.springmvc.model.minitest2.ResponseObject;
import org.example.springmvc.repository.BlogRepository;
import org.example.springmvc.services.bai6_7.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller
@CrossOrigin("*")
@RestController
@RequestMapping("/blog")
public class ControllerBlog {
    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    List<Blog> listBlog() {
        return blogService.blogLists();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteBlog(@PathVariable int id) {
        Blog blog = blogService.getBlogById(id);
        if (blog != null) {
            blogRepository.deleteById(id);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
        }
        return ResponseEntity.ok(new ResponseObject("Deleted successfully", blog, "ok"));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateBlog(@PathVariable int id, @RequestBody Blog blog) {
        Blog blogUpdate = blogService.getBlogById(id);
        if (blogUpdate != null) {
            blogUpdate.setTitle(blog.getTitle());
            blogUpdate.setContent(blog.getContent());
            blogUpdate.setAuthor(blog.getAuthor());
            blogUpdate.setCreatedAt(blog.getCreatedAt());
            blogRepository.save(blogUpdate);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));
        }
        return ResponseEntity.ok(new ResponseObject("Updated successfully", blogUpdate, "ok"));

    }

    @PostMapping
    public ResponseEntity<ResponseObject> addBlog(@RequestBody Blog blog) {
        blogService.saveBlog(blog);
        return ResponseEntity.ok(new ResponseObject("Added successfully", blog, "ok"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseObject> getBlog(@PathVariable int id) {
        Blog blog = blogService.getBlogById(id);
        return blog != null ? ResponseEntity.ok(new ResponseObject("success", blog, "ok")) : ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ResponseObject("error", "Not Found", "not found"));

    }

//    @GetMapping("/showBlog")
//    public ModelAndView showBlog(@RequestParam(defaultValue = "3") int page,
//                                 @RequestParam(defaultValue = "3") int size) {
//        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.ASC, "createdAt"));
//        Page<Blog> blogPage = blogService.blogList(pageable);
//
//        ModelAndView modelAndView = new ModelAndView("listBlog");
//        modelAndView.addObject("blogs", blogPage.getContent());
//        modelAndView.addObject("currentPage", blogPage.getNumber());
//        modelAndView.addObject("totalPages", blogPage.getTotalPages());
//        modelAndView.addObject("size", size);
//        return modelAndView;
//    }
//
//    @GetMapping("/delete/{id}")
//    public String deleteBlog(@PathVariable("id") int id) {
//        blogService.deleteBlog(id);
//        return "redirect:/blog/showBlog";
//    }
//
//    @GetMapping("/formAdd")
//    public ModelAndView formAddBlog() {
//        ModelAndView modelAndView = new ModelAndView("addBlog");
//        modelAndView.addObject("blog", new Blog());
//        return modelAndView;
//    }
//
//    @PostMapping("/addBlog")
//    public String addBlog(@ModelAttribute Blog blog) {
//        blogService.saveBlog(blog);
//        return "redirect:/blog/showBlog";
//    }
//
//    @GetMapping("/formEdit/{id}")
//    public ModelAndView formEditBlog(@PathVariable("id") int id) {
//        ModelAndView modelAndView = new ModelAndView("editBlog");
//        modelAndView.addObject("blog", blogService.getBlogById(id));
//        return modelAndView;
//    }
//
//    @PostMapping("/formEdit/editBlog/{id}")
//    public String editBlog(@ModelAttribute Blog blog, @PathVariable("id") int id) {
//        blogRepository.updateBlog(blog.getTitle(), blog.getContent(), blog.getAuthor(), blog.getCreatedAt(), id);
//        return "redirect:/blog/showBlog";
//    }
//    @GetMapping("/search")
//    public ModelAndView searchBlogs(@RequestParam String query, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
//        Page<Blog> blogPage = blogService.searchBlogs(query, PageRequest.of(page, size,Sort.by(Sort.Direction.ASC,"createdAt")));
//        ModelAndView modelAndView = new ModelAndView("listBlog");
//        modelAndView.addObject("blogs", blogPage.getContent());
//        modelAndView.addObject("currentPage", blogPage.getNumber());
//        modelAndView.addObject("totalPages", blogPage.getTotalPages());
//        modelAndView.addObject("size", size);
//        modelAndView.addObject("query", query);
//        return modelAndView;
//    }

}
