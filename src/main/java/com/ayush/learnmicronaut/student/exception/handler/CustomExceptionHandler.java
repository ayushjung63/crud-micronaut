package com.ayush.learnmicronaut.student.exception.handler;

import com.ayush.learnmicronaut.student.exception.pojo.ErrorMessage;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import jakarta.inject.Singleton;

@Singleton
public class CustomExceptionHandler implements ExceptionHandler<Exception, HttpResponse<ErrorMessage>> {
    @Override
    public HttpResponse<ErrorMessage> handle(HttpRequest request, Exception exception) {
        ErrorMessage message = new ErrorMessage();
        message.setMessage(exception.getMessage());
        message.setStatus(false);
        return HttpResponse.serverError(message).
                status(HttpStatus.BAD_REQUEST);
    }
}
