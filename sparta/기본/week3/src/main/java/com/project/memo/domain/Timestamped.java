package com.project.memo.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter // private이므로 getter이 필요함
@MappedSuperclass // Timestamped를 상속한 class(Entity)가 생성/변경 시간을 자동으로 colunm으로 인식하도록 함
@EntityListeners(AuditingEntityListener.class) // 생성/변경 시간을 자동으로 업데이트합니다.
public abstract class Timestamped { // abstract : new로 생성 불가능 (빵을 못만드는 빵틀) -> 상속이 될 때만 사용이 가능함

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime modifiedAt;
}