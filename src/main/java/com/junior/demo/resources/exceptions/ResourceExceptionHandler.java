package com.junior.demo.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.junior.demo.resources.StandardErro;
import com.junior.demo.services.exceptions.ForbiddenException;
import com.junior.demo.services.exceptions.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

  @ExceptionHandler(ObjectNotFoundException.class)
  public ResponseEntity<StandardErro> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
    StandardErro err = new StandardErro(System.currentTimeMillis(), 404, "Não encontrado", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
  }

  @ExceptionHandler(ForbiddenException.class)
  public ResponseEntity<StandardErro> unauthorized(ForbiddenException e, HttpServletRequest request) {
    StandardErro err = new StandardErro(System.currentTimeMillis(), 403, "Não autorizado", e.getMessage(), request.getRequestURI());
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
  }
}
