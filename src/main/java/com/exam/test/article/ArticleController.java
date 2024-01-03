package com.exam.test.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list() {
        return "article_list";
    }

    @GetMapping("/create")
    public String create() {
        return "article_form";
    }

    @PostMapping("/create")
    public String create(@RequestParam("title") String title, @RequestParam("content") String content) {
        this.articleService.create(title, content);

        return "redirect:/article/list";
    }
}
