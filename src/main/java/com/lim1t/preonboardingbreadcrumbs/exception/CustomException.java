package com.lim1t.preonboardingbreadcrumbs.exception;

import com.lim1t.preonboardingbreadcrumbs.constant.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CustomException extends RuntimeException {
    private final ErrorCode errorCode;
}
