package com.lim1t.preonboardingbreadcrumbs.controller;

import com.lim1t.preonboardingbreadcrumbs.dto.PageSaveRequest;
import com.lim1t.preonboardingbreadcrumbs.dto.PageResponse;
import com.lim1t.preonboardingbreadcrumbs.dto.PageSaveResponse;
import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import com.lim1t.preonboardingbreadcrumbs.service.PageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/page")
public class PageController {

    private final PageService pageService;

    public PageController(final PageService pageService) {
        this.pageService = pageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponse> getPage(@PathVariable("id") final Long id) {
        PageResponse pageResponse = pageService.getPage(id);
        return ResponseEntity.ok(pageResponse);
    }

    @GetMapping
    public ResponseEntity<List<Page>> getPageList() {
        return ResponseEntity.ok(pageService.findAll());
    }

    @PostMapping
    public ResponseEntity<Void> uploadPage(@RequestBody final PageSaveRequest pageSaveRequest) {
        PageSaveResponse pageSaveResponse = pageService.savePage(pageSaveRequest);
        return ResponseEntity.ok()
                .build();
    }
}
