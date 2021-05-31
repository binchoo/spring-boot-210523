package com.corndog.springboot.web;

import com.corndog.springboot.service.posts.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {  // 모델에 posts 값을 설정: posts를 내림차순 정렬한 리스트
        model.addAttribute("posts", postsService.findAllDesc()); // 주입한 값 사용하여 서버-사이드-렌더링 진행된다.
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }
}
