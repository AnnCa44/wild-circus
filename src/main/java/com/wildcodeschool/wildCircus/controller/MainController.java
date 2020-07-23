package com.wildcodeschool.wildCircus.controller;

import com.wildcodeschool.wildCircus.entity.Article;
import com.wildcodeschool.wildCircus.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public String index(Model out) {

        out.addAttribute("articles", articleRepository.findAll().subList(0,3));
        return "index";
    }

    @GetMapping("/add-article")
    public String addArticle(Model out) {

        out.addAttribute("article", new Article());
        return "add-article";
    }

    @PostMapping("/add-article")
    public String postFormAddPerf(@ModelAttribute Article article) {

        articleRepository.save(article);
        return "redirect:/";
    }

    @GetMapping("price-contact")
    public String priceContact() {

        return "price-contact";
    }
}
