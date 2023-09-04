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

    @Query(value = "SELECT * FROM page WHERE parent_id = :parentId", nativeQuery = true)
    List<Page> findByParentId(@Param("parentId") final Long parentId);

    @Query(value = "with recursive cte as ( select id, title, parent_id from page where id = :id  union all  select a.id, a.title, a.parent_id from page a inner join cte b on b.parent_id=a.id )  select title from cte", nativeQuery = true)
    List<String> findBread(@Param("id") final Long id);

}
