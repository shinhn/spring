package jpabook.jpashop.domain.item;

import com.fasterxml.jackson.databind.ser.Serializers;
import jpabook.jpashop.domain.BaseEntity;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // 부모테이블에 상속관계 전략(단일테이블) 지정
@DiscriminatorColumn(name = "dtype") // 부모클래스에 선언, 하위 클래스를 구분하는 용도의 컬럼
public abstract class Item extends BaseEntity {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private int price;
    private int stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    /*
     <비즈니스 로직>
     객체지향적으로 봤을 때 핵심 비즈니스 로직은 해당 entity(item)가 가지고 있는게 바람직하다.
     관리하기도 편함
     */
    // stock 증가
    public void addStock(int quantity){
        this.stockQuantity += quantity;
    }

    // stock 감소
    public void removeStock(int quantity){
        int restStock = this.stockQuantity - quantity;
        if(restStock < 0){
            throw new NotEnoughStockException("need more stock");
        }
        this.stockQuantity = restStock;
    }
}
