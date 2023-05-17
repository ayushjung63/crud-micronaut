
package com.ayush.learnmicronaut.httpclient.declarativeclient.service;


import com.ayush.learnmicronaut.httpclient.pojos.Post;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import org.reactivestreams.Publisher;

@Client(id = "jsonplaceholder")
public interface JsonPlaceHolderApiClient {

    @Get("/posts")
    Publisher<Post> getAllPost();
}

