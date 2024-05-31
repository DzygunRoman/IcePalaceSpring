package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="OrderDetails")
public class OrderDetail {
    @Id//аннотация указывает что данное поле будет ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Стратегия формирования ID
    @Column(name = "id")
    private Long id;
    private Integer Quantity;
    private Integer Price;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime DateTime;
    private Integer TotalSum;
    private Integer GrandSum;
    @OneToOne
    private Product product;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="order_id")
    private Order order;

    public void setProduct(Long id) {
    }
}
