package erivelto.system.AluguelCarros.exceptions;

import erivelto.system.AluguelCarros.dto.ExceptionDTO;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Arrays;

@RestControllerAdvice
public class ManagerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> customArgumentNotValidException(MethodArgumentNotValidException exception, ServletWebRequest request){
        var errors = exception.getFieldErrors();

        var error = exception.getBody();

        var endpoint = request.getRequest().getRequestURI();
        int status = error.getStatus();
        String type = error.getType().toString();
        String detail = errors.getFirst().getField() + " " + errors.getLast().getDefaultMessage();

        ExceptionDTO returnException = new ExceptionDTO(endpoint, status, type, detail);

        return new ResponseEntity<ExceptionDTO>(returnException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<ExceptionDTO> notFoundId(Exception exception, ServletWebRequest request){
        var endpoint = request.getRequest().getRequestURI();
        int status = HttpStatus.NOT_FOUND.value();
        String type = HttpStatus.NOT_FOUND.getReasonPhrase();
        String detail = exception.getMessage();

        ExceptionDTO returnException = new ExceptionDTO(endpoint, status, type, detail);

        return new ResponseEntity<ExceptionDTO>(returnException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ExceptionDTO> updateData(Exception exception, ServletWebRequest request){

        var endpoint = request.getRequest().getRequestURI();
        int status = HttpStatus.BAD_REQUEST.value();
        String type = HttpStatus.BAD_REQUEST.getReasonPhrase();
        String detail = "Update impossible";

        ExceptionDTO returnException = new ExceptionDTO(endpoint, status, type, detail);

        return new ResponseEntity<ExceptionDTO>(returnException, HttpStatus.BAD_REQUEST);
    }
}
