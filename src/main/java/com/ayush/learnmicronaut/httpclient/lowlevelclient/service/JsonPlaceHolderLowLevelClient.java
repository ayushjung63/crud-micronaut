package com.ayush.learnmicronaut.httpclient.lowlevelclient.service;

import com.ayush.learnmicronaut.httpclient.pojos.Post;
import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MutableHttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.util.List;

@Singleton
public class JsonPlaceHolderLowLevelClient {
    private final HttpClient httpClient;
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";

    public JsonPlaceHolderLowLevelClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public List<Post> getAllPost(){
        String path="posts";
        URI uri= UriBuilder.of(
                BASE_URL+path
        ).build();
        MutableHttpRequest<Object> httpRequest = HttpRequest.GET(uri);
        Mono<List<Post>> from = Mono.from(httpClient.retrieve(httpRequest, Argument.listOf(Post.class)));
        return from.block();
    }
}
