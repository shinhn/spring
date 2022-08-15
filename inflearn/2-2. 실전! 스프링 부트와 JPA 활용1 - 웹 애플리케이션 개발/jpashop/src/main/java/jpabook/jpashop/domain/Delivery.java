package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Delivery extends BaseEntity{
    @Id
    @GeneratedValue
    @Column
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING) // EnumType.ORDINAL - 숫자로 들어감(default, 중간에 enum이 하나 추가될 경우에 기존 숫자들이 밀리기 때문에 db 정보가 바뀌므로 절대 ORDINAL을 쓰면 안된다..), EnumType.STRING - 문자열로 들어감
    private DeliveryStatus status; // READY, COMP
}
