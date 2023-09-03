package com.lim1t.preonboardingbreadcrumbs.repository;

import com.lim1t.preonboardingbreadcrumbs.entity.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {

    @Query(value = "SELECT * FROM page WHERE id = :id", nativeQuery = true)
    Optional<Page> findById(@Param("id") final Long id);

//    @Query("select p from Page p where p.parentId = :parentId")
    @Query(value = "SELECT * FROM page WHERE parent_id = :parentId", nativeQuery = true)
    List<Page> findByParentId(@Param("parentId") final Long parentId);
}
