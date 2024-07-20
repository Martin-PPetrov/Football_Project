package org.football_project.services.exceptions;


import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Getter
public class ObjectNotFoundException extends RuntimeException {

    private final Object id;

    public ObjectNotFoundException(String message, Object id) {
        super(message);
        this.id = id;
    }

}
