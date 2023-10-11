package com.server.dosopt.seminar.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class HttpResponse<T> {
    private int code;
    private String status;
    private T data;

    public HttpResponse (HttpStatus status) {
        this.code = status.value();
        this.status = status.getReasonPhrase();
    }

    public HttpResponse (HttpStatus status, T data) {
        this.code = status.value();
        this.status = status.getReasonPhrase();
        this.data = data;
    }
}
