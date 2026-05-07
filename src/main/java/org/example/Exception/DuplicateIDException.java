package org.example.Exception;

public class DuplicateIDException extends RuntimeException {
    public DuplicateIDException(String message) {
        super(message);
    }
}