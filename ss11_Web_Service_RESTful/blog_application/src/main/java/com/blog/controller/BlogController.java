package com.blog.controller;

import com.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {

    @Autowired
    IBlogService blogService;

}
