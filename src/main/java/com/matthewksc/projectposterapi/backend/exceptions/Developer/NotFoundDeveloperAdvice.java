package com.matthewksc.projectposterapi.backend.exceptions.Developer;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundDeveloperAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundDeveloperException.class)
    public String NotFoundDeveloperHandler(NotFoundDeveloperException exception){
        return exception.getMessage();
    }
}
