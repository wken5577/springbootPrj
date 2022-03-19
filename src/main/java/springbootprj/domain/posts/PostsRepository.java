package springbootprj.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Post, Long> {

    @Query("select p from Post p order by p.modifiedDate desc")
    List<Post> findAllModDateDesc();

}
