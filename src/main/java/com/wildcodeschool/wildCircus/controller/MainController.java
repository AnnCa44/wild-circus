package com.wildcodeschool.wildCircus.controller;

import com.wildcodeschool.wildCircus.entity.Article;
import com.wildcodeschool.wildCircus.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Controller
public class MainController {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    @GetMapping("/")
    public String index(Model out) {

        out.addAttribute("articles", articleRepository.findAll());
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

    @GetMapping("/email")
    public String email(@RequestParam String name,
                        @RequestParam String mail,
                        @RequestParam String message) {

        try {
            sendEmail(name, mail, message);
        } catch (MailException | MessagingException exception) {
            return exception.getMessage();
        }
        return "price-contact";
    }

    void sendEmail(String name, String mail, String message) throws MailException, MessagingException {

        MimeMessage msg = javaMailSender.createMimeMessage();

        // true = multipart message
        MimeMessageHelper helper = new MimeMessageHelper(msg, false);

        helper.setTo(name);

        helper.setSubject(mail);
        helper.setText("<h1>" + message + "</h1><br><a href=\"#lol\">Se désabonner</a>", true);

        javaMailSender.send(msg);
    }
}
