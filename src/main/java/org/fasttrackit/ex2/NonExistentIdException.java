package org.fasttrackit.ex2;

public class NonExistentIdException extends RuntimeException{
    private final String message;
    public NonExistentIdException(String message){
        this.message = message;
    }
}
