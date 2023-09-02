package com.lim1t.preonboardingbreadcrumbs.repository;

import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query("select p from Page p where p.parentId = :parentId")
    List<Page> findByParentId(@Param("parentId") final Long parentId);
}
