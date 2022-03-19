package springbootprj.service.posts;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springbootprj.domain.posts.Post;
import springbootprj.domain.posts.PostsRepository;
import springbootprj.web.dto.PostResponseDto;
import springbootprj.web.dto.PostsSaveRequestDto;
import springbootprj.web.dto.PostsUpdateRequestDto;

@Service
@RequiredArgsConstructor
@Transactional
public class PostsService {

    private final PostsRepository postsRepository;


    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }


    public Long update(Long postId, PostsUpdateRequestDto requestDto) {
        Post targetPost = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다. id = " + postId));

        targetPost.update(requestDto.getTitle(),requestDto.getContent());
        return postId;
    }

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long postId) {
        Post findPost = postsRepository.findById(postId)
                .orElseThrow(() -> new IllegalStateException("해당 게시글이 없습니다. id = " + postId));
        return new PostResponseDto(findPost);
    }


}
