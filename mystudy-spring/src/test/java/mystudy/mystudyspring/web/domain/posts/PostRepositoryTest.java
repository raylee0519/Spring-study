package mystudy.mystudyspring.web.domain.posts;


import static org.assertj.core.api.Assertions.assertThat;
import org.aspectj.lang.annotation.After;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostsRepository postsRepository;

    @After("execution(* mystudy.mystudyspring.web.domain.posts.*")
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void callup(){
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("adksad@naver.com")
                .build());

        List<Posts> postsList = postsRepository.findAll();

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

}
