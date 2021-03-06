package ua.darkminimum.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason =  "Research was not found")
public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }


    public NotFoundException() {

    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
