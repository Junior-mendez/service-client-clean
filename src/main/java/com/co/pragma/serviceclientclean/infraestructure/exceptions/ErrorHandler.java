package com.co.pragma.serviceclientclean.infraestructure.exceptions;

import org.hibernate.exception.JDBCConnectionException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.co.pragma.serviceclientclean.domain.exceptions.ClientCreateException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientDisableException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundDocumentException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientNotFoundIdException;
import com.co.pragma.serviceclientclean.domain.exceptions.ClientUpdateException;
import com.co.pragma.serviceclientclean.domain.exceptions.ErrorResponse;

import java.util.Date;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value =  {ClientNotFoundDocumentException.class})
    public ResponseEntity<ErrorResponse> notFoundException(ClientNotFoundDocumentException ex){
        return new ResponseEntity<>(ErrorResponse.builder().error("Cliente no encontrado")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @ExceptionHandler(value =  {ClientNotFoundIdException.class})
    public ResponseEntity<ErrorResponse> notFoundIdException(ClientNotFoundIdException ex){
        return new ResponseEntity<>(ErrorResponse.builder().error("Cliente no existe")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @ExceptionHandler(value =  {ClientCreateException.class})
    public ResponseEntity<ErrorResponse> notFoundException(ClientCreateException ex){
        return new ResponseEntity<>(ErrorResponse.builder().error("Cliente no creado")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(ex.getMessage())
                .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);

    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> handleMissingRequestBody(Exception ex, WebRequest request) {
        return new ResponseEntity<>(ErrorResponse.builder().error("Cuerpo de llamada no es válido"+ request.getDescription(false))
                .status(HttpStatus.BAD_REQUEST.value())
                .message(ex.getCause().toString())
                .timestamp(new Date().toString()).build(),HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ClientUpdateException.class)
    public ResponseEntity<ErrorResponse> notUpdateClient(ClientUpdateException ex) {
    	 return new ResponseEntity<>(ErrorResponse.builder().error("Cliente no actualizado")
                 .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                 .message(ex.getMessage())
                 .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(ClientDisableException.class)
    public ResponseEntity<ErrorResponse> notDisableException(ClientDisableException ex) {
    	 return new ResponseEntity<>(ErrorResponse.builder().error("Cliente no deshabilitado")
                 .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                 .message(ex.getMessage())
                 .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler(JDBCConnectionException.class)
    public ResponseEntity<ErrorResponse> jdbcExcetion(JDBCConnectionException ex) {
    	 return new ResponseEntity<>(ErrorResponse.builder().error("Problema al conectar con base de datos")
                 .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                 .message(ex.getMessage())
                 .timestamp(new Date().toString()).build(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
