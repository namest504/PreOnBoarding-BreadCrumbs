package com.lim1t.preonboardingbreadcrumbs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorDto {
    private int status;
    private String message;

    public ErrorDto(final int status, final String message) {
        this.status = status;
        this.message = message;
    }
}
