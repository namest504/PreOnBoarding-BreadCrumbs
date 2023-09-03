package com.lim1t.preonboardingbreadcrumbs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageSaveRequest {
    private String title;
    private String content;
    private Long parentId;

    public PageSaveRequest(final String title, final String content, final Long parentId) {
        this.title = title;
        this.content = content;
        this.parentId = parentId;
    }
}
