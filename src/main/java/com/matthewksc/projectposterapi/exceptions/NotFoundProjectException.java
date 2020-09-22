package com.matthewksc.projectposterapi.exceptions;

public class NotFoundProjectException extends RuntimeException{

    public NotFoundProjectException(Long id){
        super("No such project with provided id: "+id);
    }

    public NotFoundProjectException(){
        super("No object of Project were presented");
    }
}
