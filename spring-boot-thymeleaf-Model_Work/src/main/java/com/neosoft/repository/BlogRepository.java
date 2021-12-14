package com.neosoft.repository;

import com.neosoft.entity.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.neosoft.controller.BlogController;
import org.springframework.stereotype.Repository;
@Repository
public interface BlogRepository extends PagingAndSortingRepository<Blog,Long> {
}
