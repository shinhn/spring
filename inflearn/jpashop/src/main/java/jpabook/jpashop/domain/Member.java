package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "member_id") // 엔티티의 식별자는 id 를 사용하고 PK 컬럼명은 member_id 를 사용

    private Long id;
    private String name;

    @Embedded // JPA 내장 타입 (새로운 값 타입을 직접 정의해서 사용)
    private Address address;

    @OneToMany(mappedBy = "member") // order의 member에 의해 매핑됨(읽기전용), 주인(order의 member)이 아닌쪽에 표시
    private List<Order> Orders = new ArrayList<>();


}
