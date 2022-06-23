package com.selecshop.week4.models;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // DB 테이블 역할
@Getter // get 함수를 일괄적으로 생성
@NoArgsConstructor // 기본 생성자 만들어줌

public class Product extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)// ID가 자동으로 생성 및 증가
    @Id
    private Long id;

    @Column(nullable = false) // 반드시 값을 가지도록 설정
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private int lprice;

    @Column(nullable = false)
    private int myprice;

    public Product(ProductRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.image = requestDto.getImage();
        this.link = requestDto.getLink();
        this.lprice = requestDto.getLprice();
        this.myprice = 0;
    }

    public void update(ProductMypriceRequestDto requestDto) {
        this.myprice = requestDto.getMyprice();
    }

    public void updateByItemDto(ItemDto itemDto){
        this.lprice = itemDto.getLprice();
    }
}
