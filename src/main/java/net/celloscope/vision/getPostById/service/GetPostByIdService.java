package net.celloscope.vision.getPostById.service;

import lombok.extern.slf4j.Slf4j;
import net.celloscope.vision.getPostById.model.Post;
import net.celloscope.vision.getPostById.model.RandomBank;
import net.celloscope.vision.getPostById.repository.GetPostByIdRepository;
import net.celloscope.vision.getPostById.request.PostRequest;
import net.celloscope.vision.getPostById.response.PostResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class GetPostByIdService {

    @Autowired
    private GetPostByIdRepository repository;

    private WebClient webClient;

    private GetPostByIdService(){
        this.webClient = WebClient.builder().build();
    }


    public Mono<ResponseEntity<PostResponse>> getResponse(PostRequest request) {
        Mono<Post> post = repository.getPostById(request.getPostId());


        // random API call using webclient to demonstrate REST API call
        getRandomUserInfoViaAPICall()
                .doOnSubscribe(subscription -> System.out.println("Subscribed"))
                .doOnNext(data -> System.out.println("Received data: " + data))
                .doOnSuccess(data -> System.out.println("Mono completed successfully"))
                .doOnError(error -> System.err.println("Mono encountered an error: " + error))
                .subscribe();

        Mono<PostResponse> postResponse = post.map(p -> PostResponse.builder()
                .id(p.getId())
                .title(p.getTitle())
                .content(p.getContent())
                .message("Successfully Retrieved").build());

        return postResponse.map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<RandomBank> getRandomUserInfoViaAPICall(){
        return webClient.get()
                .uri("https://random-data-api.com/api/bank/random_bank")
                .retrieve()
                .bodyToMono(RandomBank.class);
    }

}
