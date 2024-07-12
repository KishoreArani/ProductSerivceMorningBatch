package com.example.productservicemorningbatch.advices;

import com.example.productservicemorningbatch.dtos.ExceptionDto;
import com.example.productservicemorningbatch.exceptions.InvalidProductIdException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(InvalidProductIdException.class)
    public ResponseEntity<ExceptionDto> handleInvalidProductIdException(){
        ExceptionDto exceptionDto = new ExceptionDto();
        exceptionDto.setMessage("Invalid productId passed, Please pass valid productId");
        return new ResponseEntity<>(exceptionDto, HttpStatus.BAD_REQUEST);
    }
}
