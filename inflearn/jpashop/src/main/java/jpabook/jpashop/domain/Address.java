package jpabook.jpashop.domain;

import javax.persistence.Embeddable;

@Embeddable // JPA 내장 타입 (새로운 값 타입을 직접 정의해서 사용), @Embeddable 와 사용하는 쪽의 @Embedded 둘중 하나만 있어도 되지만 그냥 두개 다 써줌
public class Address {

    private String city;
    private String street;
    private String zipcode;
}
