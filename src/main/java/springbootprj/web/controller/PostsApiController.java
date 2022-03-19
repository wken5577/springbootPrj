package springbootprj.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springbootprj.service.posts.PostsService;
import springbootprj.web.dto.PostResponseDto;
import springbootprj.web.dto.PostsSaveRequestDto;
import springbootprj.web.dto.PostsUpdateRequestDto;

@RestController
@RequiredArgsConstructor
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{postId}")
    public Long update(@PathVariable Long postId, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(postId, requestDto);
    }


    @GetMapping("/api/v1/posts/{postId}")
    public PostResponseDto findById(@PathVariable Long postId) {
        return postsService.findById(postId);
    }



}
