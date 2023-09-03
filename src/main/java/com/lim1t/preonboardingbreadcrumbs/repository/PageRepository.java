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

    @Query(value = "WITH RECURSIVE cte AS (" +
            "SELECT id, title, parent_id FROM page WHERE id = :id " +
            "UNION ALL " +
            "SELECT a.id, a.title, a.parent_id FROM page AS a INNER JOIN cte ON a.parent_id=cte.id)  SELECT * FROM cte;", nativeQuery = true)
    List<?> findBread(@Param("id") final Long id);

}
