package jpql;

import javax.persistence.*;

@Entity
@Table(name = "ORDERS") // 관례상 order라는 이름 대신 orders 사용
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private int orderAmount;

    @Embedded
    private Address address;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    public Long getId() {
        return id;
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    public Address getAddress() {
        return address;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderAmount(int orderAmount) {
        this.orderAmount = orderAmount;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
