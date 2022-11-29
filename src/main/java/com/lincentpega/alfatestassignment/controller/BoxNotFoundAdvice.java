package com.lincentpega.alfatestassignment.controller;

import com.lincentpega.alfatestassignment.exception.BoxNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class BoxNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(BoxNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String boxNotFoundHandler(BoxNotFoundException exception) {
         return exception.getMessage();
    }
}
