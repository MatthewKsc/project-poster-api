package com.matthewksc.projectposterapi.exceptions.ProjectOwner;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class NotFoundProjectOwnerAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundProjectOwnerException.class)
    public String NotFoundProjectHandler(NotFoundProjectOwnerException exception){
        return exception.getMessage();
    }
}
