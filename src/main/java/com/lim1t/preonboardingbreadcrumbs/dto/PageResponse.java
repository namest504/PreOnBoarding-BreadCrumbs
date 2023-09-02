package com.lim1t.preonboardingbreadcrumbs.dto;

import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class PageResponse {
    private Long id;
    private String title;
    private String content;
    private List<SubPageResponse> subPages;
    private String breadcrumbs;
    private Long parentId;

    private PageResponse(final Long id, final String title, final String content, final List<SubPageResponse> subPages, final String breadcrumbs, final Long parentId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.subPages = subPages;
        this.breadcrumbs = breadcrumbs;
        this.parentId = parentId;
    }

    public static PageResponse of(final Page page, final List<SubPageResponse> list, final String breadcrumbs) {
        return new PageResponse(page.getId(), page.getTitle(), page.getContent(), list, breadcrumbs, page.getParentId());
    }
}
