package springbootprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import springbootprj.config.oauth.LoginUser;
import springbootprj.config.oauth.dto.SessionUser;
import springbootprj.service.posts.PostsService;
import springbootprj.web.dto.PostListResponseDto;
import springbootprj.web.dto.PostResponseDto;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user) {
        List<PostListResponseDto> result = postsService.findAllModDateDesc();
        model.addAttribute("posts",result);

        model.addAttribute("user", user);

        return "index";
    }

    @GetMapping("/posts/update/{postId}")
    public String postUpdate(@PathVariable Long postId, Model model) {
        PostResponseDto dto = postsService.findById(postId);
        model.addAttribute("post",dto);

        return "posts-update";
    }


}
