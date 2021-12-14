package com.neosoft.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.neosoft.controller.BlogController;
import com.neosoft.repository.BlogRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BlogController {
   @Autowired
   private BlogRepository blogRepository;
   
   @GetMapping(value = "/blogPageable")
   Page blogPageable(Pageable pageable) {
       return blogRepository.findAll(pageable);
   }
}