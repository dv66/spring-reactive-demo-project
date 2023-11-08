package net.celloscope.vision.getPostById.controllers;

import net.celloscope.vision.getPostById.request.PostRequest;
import net.celloscope.vision.getPostById.response.PostResponse;
import net.celloscope.vision.getPostById.service.GetPostByIdService;
import net.celloscope.common.constants.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class GetPostByIdController {

    @Autowired
    private GetPostByIdService service;

    @RequestMapping(value = Api.GET_POST_BY_POST_ID,
            consumes = "application/json",
            produces = "application/json",
            method = RequestMethod.POST)
    public Mono<ResponseEntity<PostResponse>> getPosts(@RequestBody PostRequest request){
        return service.getResponse(request);
    }
}
