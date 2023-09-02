package com.lim1t.preonboardingbreadcrumbs.exception;

import com.lim1t.preonboardingbreadcrumbs.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.lim1t.preonboardingbreadcrumbs.constant.ErrorCode.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler({CustomException.class})
    protected ResponseEntity<?> handleCustomException(final CustomException ex) {
        return new ResponseEntity<>(new ErrorDto(ex.getErrorCode().getStatus(), ex.getErrorCode().getMessage()), HttpStatus.valueOf(ex.getErrorCode().getStatus()));
    }

    @ExceptionHandler({Exception.class})
    protected ResponseEntity<?> handleServerException(final Exception ex) {
        return new ResponseEntity<>(new ErrorDto(INTERNAL_SERVER_ERROR.getStatus(), INTERNAL_SERVER_ERROR.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
