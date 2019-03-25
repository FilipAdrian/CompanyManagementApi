package com.company.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class DeletedSuccesfullException extends RuntimeException {
    public DeletedSuccesfullException() {
        super("The employee was deleted");
    }
}
