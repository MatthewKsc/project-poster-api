package com.matthewksc.projectposterapi.backend.exceptions.ProjectOwner;

public class NotFoundProjectOwnerException extends RuntimeException{

    public NotFoundProjectOwnerException(Long id){
        super("No such Project Owner with id: " +id);
    }

    public NotFoundProjectOwnerException(){
        super("No object of ProjectOwner were presented");
    }
}
