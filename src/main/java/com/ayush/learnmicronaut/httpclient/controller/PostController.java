package com.ayush.learnmicronaut.httpclient.controller;

//import com.ayush.learnmicronaut.httpclient.declarativeclient.service.JsonPlaceHolderApiClient;
import com.ayush.learnmicronaut.httpclient.declarativeclient.service.JsonPlaceHolderApiClient;
import com.ayush.learnmicronaut.httpclient.pojos.Post;
import com.ayush.learnmicronaut.httpclient.lowlevelclient.service.JsonPlaceHolderLowLevelClient;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;
import org.reactivestreams.Publisher;

import java.util.List;

@Controller("/api/post")
public class PostController {
    @Inject
    private JsonPlaceHolderLowLevelClient jsonPlaceHolderLowLevelClient;
    @Inject
    private JsonPlaceHolderApiClient jsonPlaceHolderApiClient;

    @Get(value = "/low-level-client/list")
    public List<Post> fetchAllPostV1(){
        List<Post> posts = jsonPlaceHolderLowLevelClient.getAllPost();
        return posts;
    }

    @Get(value = "/declarative-client/list")
    public Publisher<Post> fetchAllPostV2(){
        Publisher<Post> allPost = jsonPlaceHolderApiClient.getAllPost();
        return allPost;
    }
}
