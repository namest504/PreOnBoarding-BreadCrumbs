package com.lim1t.preonboardingbreadcrumbs.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PAGE_NOT_FOUND(404, "존재하지 않는 페이지 입니다."),
    INTERNAL_SERVER_ERROR(500, "서버 에러 발생");

    private final int status;
    private final String message;
}
