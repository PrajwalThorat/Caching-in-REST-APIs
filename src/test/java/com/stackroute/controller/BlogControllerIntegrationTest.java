package com.stackroute.controller;

import com.stackroute.domain.Blog;
import com.stackroute.service.BlogService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class BlogControllerIntegrationTest {
    @Autowired
    private BlogService blogService;

    private Blog blog;
    private List<Blog> blogList;

    @BeforeEach
    void setUp() {
        blog = new Blog(1, "Blog 1", "John", "Sample Blog for Testing");
        blogList = new ArrayList<>();
        blogList.add(blog);
    }

    @AfterEach
    void tearDown() {
        blog = null;
    }

    @Test
    void givenCallToGetAllBlogsThenListShouldNotBeNull() throws Exception {
        List<Blog> retrievedBlogs = blogService.getAllBlogs();
        assertNotNull(retrievedBlogs);
    }

    @Test
    void givenBlogToUpdateThenShouldReturnUpdatedBlog() throws Exception {
        blog.setBlogContent("Updated Blog content");
        blogService.updateBlog(blog);
        assertEquals("Updated Blog content", blog.getBlogContent());
    }
}