package com.nmy.randomword.Handler;

import com.nmy.randomword.Exception.CustomException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class CustomExceptonHandler {
    @ExceptionHandler(CustomException.class)
    protected ResponseEntity<String> ResponsCustonException(CustomException e){
        return ResponseEntity.status(e.getExceptonCode().getHttpStatus()).body(e.getExceptonCode().getMessage());
    }
}
