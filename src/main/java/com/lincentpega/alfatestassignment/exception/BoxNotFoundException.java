package com.lincentpega.alfatestassignment.exception;

public class BoxNotFoundException extends RuntimeException {
    public BoxNotFoundException(Integer id) {
        super("Could not find box" + id);
    }
}
