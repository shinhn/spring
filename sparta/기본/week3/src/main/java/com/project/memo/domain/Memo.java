package com.project.memo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // 테이블과 연계됨을 스프링에게 알려줌
@NoArgsConstructor // 기본생성자 만듦
@Getter // getting을 대신 만들어줌 (lombok)
public class Memo extends Timestamped {
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    public Memo(String username, String contents){
        this.username = username;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.username = requestDto.getUsername();
        this.contents = requestDto.getContents();
    }
}
