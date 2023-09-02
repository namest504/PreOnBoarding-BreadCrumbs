package com.lim1t.preonboardingbreadcrumbs.dto;

import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PageSaveResponse {
    private Long id;

    private PageSaveResponse(final Long id) {
        this.id = id;
    }

    public static PageSaveResponse from(final Page page) {
        return new PageSaveResponse(page.getId());
    }
}
