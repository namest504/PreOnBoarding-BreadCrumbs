package com.lim1t.preonboardingbreadcrumbs.dto;

import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SubPageResponse {
    private Long id;
    private String title;

    private SubPageResponse(final Long id, final String title) {
        this.id = id;
        this.title = title;
    }

    public static SubPageResponse of(final Page page) {
        return new SubPageResponse(page.getId(), page.getTitle());
    }
}
