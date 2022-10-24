package com.musica.catalogo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

/*
@ResponseStatus marks a method or exception class with the status code and reason message that should be returned.
The status code is applied to the HTTP response when the handler method is invoked, or whenever the specified exception is thrown.
It overrides status information set by other means, like ResponseEntity or redirect.
*/
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    /*
    The @Serial annotation lets you make a similar kind of assertion:
    that you intend that this is one of those magic serialization members (fields and methods), and if it does not match the profile,
    the compiler should alert you with an error. And it provides a similar hint to readers that this member is going to be used by serialization.
    */
    @Serial
    private static final long serialVersionUID = 1L;

    public ResourceNotFoundException(String message) {
        super(message);
    }

}
