package com.matthewksc.projectposterapi.exceptions.Address;

public class NotFoundAddressException extends RuntimeException{

    public NotFoundAddressException(Long id){
        super("No such Address with id: "+id);
    }

    public NotFoundAddressException(){
        super("No object of address were presented");
    }
}
