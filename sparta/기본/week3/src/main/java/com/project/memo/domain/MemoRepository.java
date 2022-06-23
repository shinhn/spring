package com.project.memo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MemoRepository extends JpaRepository<Memo, Long> {
    // 1. 수정날짜 순으로 조회
    // List<Memo> findAllByOrderByModifiedAtDesc();
    // findAll(모두 찾기) By OrderBy(순서대로) ModifiedAt(수정된 날짜) Desc(내림차순 -> 최신순)
    // https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods

    // 2. 지정한 시간 사이에 수정날짜 순으로 조회
    // 모두 찾아라 지정된 시간 사이에 수정된 시간으로 정렬된 것들
    List<Memo> findAllByModifiedAtBetweenOrderByModifiedAtDesc(LocalDateTime start, LocalDateTime end);
}
