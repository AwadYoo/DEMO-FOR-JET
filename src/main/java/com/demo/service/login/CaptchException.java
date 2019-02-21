package com.demo.service.login;


import org.springframework.security.core.AuthenticationException;

public class CaptchException extends AuthenticationException {

    public CaptchException(String explanation) {
        super(explanation);
    }
}







