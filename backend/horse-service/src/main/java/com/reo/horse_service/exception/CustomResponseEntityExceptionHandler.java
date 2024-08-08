package com.reo.horse_service.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorEntity> handleEntityAlreadyExists(EntityAlreadyExistsException ex) {
        ErrorEntity errorEntity = new ErrorEntity(ex.getMessage(), ex.getIdEntity());
        return new ResponseEntity<>(errorEntity, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityDoesNotExistException.class)
    public ResponseEntity<ErrorEntity> handleEntityDoesNotExist(EntityDoesNotExistException ex) {
        ErrorEntity errorEntity = new ErrorEntity(ex.getMessage(), ex.getIdEntity());
        return new ResponseEntity<>(errorEntity, HttpStatus.BAD_REQUEST);
    }

    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

        ErrorEntity errorEntity = new ErrorEntity(ex.getFieldErrors().get(0).getDefaultMessage(), -1L);
        return new ResponseEntity<>(errorEntity, HttpStatus.BAD_REQUEST);
    }
}
