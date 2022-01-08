package com.example.myrestfulservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP Status code
//2xx -> OK
//4xx -> Client error
//5xx -> Server error
@ResponseStatus(HttpStatus.NOT_FOUND) //하단의 오류가 나면 not found 오류라고 넘김
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
