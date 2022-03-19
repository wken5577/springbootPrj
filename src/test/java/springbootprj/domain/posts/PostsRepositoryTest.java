package springbootprj.domain.posts;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @AfterEach
    public void cleanDb() {
       postsRepository.deleteAllInBatch();
    }


    @Test
    public void post_save_find() {
        String title = "test 게시글";
        String content = "테스트 본문";

        postsRepository.save(
                Post.builder()
                        .title(title)
                        .content(content)
                        .author("asdkj@naver.com")
                        .build()
        );

        List<Post> postList = postsRepository.findAll();

        Post post = postList.get(0);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);


    }

}