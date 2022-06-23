package com.example.week2.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

// JpaRepository는 인터페이스이다. 인터페이스에 미리 검색 메소드를 정의 해 두는 것으로, 메소드를 호출하는 것만으로 스마트한 데이터 검색을 할 수 있게 되는 것이다.