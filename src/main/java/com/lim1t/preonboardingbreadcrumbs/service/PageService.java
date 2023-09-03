package com.lim1t.preonboardingbreadcrumbs.service;

import com.lim1t.preonboardingbreadcrumbs.constant.ErrorCode;
import com.lim1t.preonboardingbreadcrumbs.dto.PageSaveRequest;
import com.lim1t.preonboardingbreadcrumbs.dto.PageResponse;
import com.lim1t.preonboardingbreadcrumbs.dto.PageSaveResponse;
import com.lim1t.preonboardingbreadcrumbs.dto.SubPageResponse;
import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import com.lim1t.preonboardingbreadcrumbs.exception.CustomException;
import com.lim1t.preonboardingbreadcrumbs.repository.PageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class PageService {

    private final PageRepository pageRepository;

    public PageService(final PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }

    @Transactional(readOnly = true)
    public PageResponse getPage(final Long pageId) {
        Page page = pageRepository.findById(pageId)
                .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND));

        List<SubPageResponse> subPageResponses = pageRepository.findByParentId(pageId)
                .stream()
                .map(SubPageResponse::of)
                .toList();

        return PageResponse
                .of(page, subPageResponses, getBreadcrumbs(pageId));
    }

    private String getBreadcrumbs(Long id) {
        List<String> breadcrumbs = new ArrayList<>();

        while (id != null) {
            Page page = pageRepository.findById(id)
                    .orElseThrow(() -> new CustomException(ErrorCode.PAGE_NOT_FOUND));
            breadcrumbs.add(page.getTitle());

            id = page.getParentId();
        }

        Collections.reverse(breadcrumbs);

        return String.join(" > ", breadcrumbs);
    }

//    @Transactional
//    public PageSaveResponse savePage(final PageSaveRequest pageSaveRequest) {
//        Page page = pageRepository.save(Page.builder()
//                .title(pageSaveRequest.getTitle())
//                .content(pageSaveRequest.getContent())
//                .parentId(pageSaveRequest.getParentId())
//                .build());
//        return PageSaveResponse.from(page);
//    }
//
//    @Transactional(readOnly = true)
//    public List<Page> findAll() {
//        return pageRepository.findAll();
//    }
}
