package com.matthewksc.projectposterapi.backend.exceptions.Developer;

public class NotFoundDeveloperException extends RuntimeException {

    public NotFoundDeveloperException(Long id) {
        super("No such Developer with id: " +id);
    }

    public NotFoundDeveloperException() {
        super("No object of developer were presented");
    }
}
