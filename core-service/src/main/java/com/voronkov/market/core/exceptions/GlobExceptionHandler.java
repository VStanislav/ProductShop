package com.voronkov.market.core.exceptions;

import com.voronkov.market.api.AppError;
import com.voronkov.market.api.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
@Slf4j
public class GlobExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e){
        log.error(e.getMessage(),e);
        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(),
                e.getMessage()),HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler
//    public ResponseEntity<FildsValidatorError> catchValidationException(ValidationException e){
//        log.error(e.getMessage(),e);
//        return new ResponseEntity<>(new FildsValidatorError(e.getErrorMessage()),HttpStatus.BAD_REQUEST);
//    }
}
