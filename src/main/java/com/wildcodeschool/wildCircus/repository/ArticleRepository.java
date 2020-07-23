package com.wildcodeschool.wildCircus.repository;

import com.wildcodeschool.wildCircus.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


}
