package com.sumanthtp.jobListing.controller;

import com.sumanthtp.jobListing.model.Post;
import com.sumanthtp.jobListing.repository.PostRepository;
import com.sumanthtp.jobListing.repository.SearchRepo;
import com.sumanthtp.jobListing.repository.SearchRepoImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameters;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepoImpl srepo;

    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse res) throws IOException {
        res.sendRedirect("/swagger-ui.html");
    }

    @Operation(summary = "Get all posts")
    @GetMapping(value = "/posts")
    @CrossOrigin
    public List<Post> getAllPosts() {
        return repo.findAll();
    }

    @Operation(summary = "Add post")
    @PostMapping(value = "/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post p) {
        return repo.save(p);
    }

    // posts/java
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text)
    {
        return srepo.findByText(text);
    }
}
