package erivelto.system.AluguelCarros.exceptions;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundIdException extends RuntimeException {

    public NotFoundIdException(String e) {
        super(e);
    }
}
