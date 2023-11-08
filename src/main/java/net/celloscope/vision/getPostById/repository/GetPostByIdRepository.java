package net.celloscope.vision.getPostById.repository;

import lombok.extern.slf4j.Slf4j;
import net.celloscope.common.repository.BaseRepository;
import net.celloscope.vision.getPostById.model.Post;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import java.util.*;


/*
* References : https://docs.spring.io/spring-framework/reference/data-access/r2dbc.html
* References : https://hantsy.github.io/spring-r2dbc-sample/intro.html
*
* */

@Service
@Slf4j
public class GetPostByIdRepository extends BaseRepository {

    public Mono<Post> getPostById(String postId) {

       return client.sql("SELECT * from posts WHERE id = :id")
                .bind("id", UUID.fromString(postId))
                .map(
                        p -> Post.builder()
                                .id(Objects.requireNonNull(p.get("id", UUID.class)).toString())
                                .content(p.get("content", String.class))
                                .title(p.get("title", String.class))
                                .build()
                ).one();

    }

}
