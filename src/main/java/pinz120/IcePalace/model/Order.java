package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="Orders")
public class Order {
    @Id//аннотация указывает что данное поле будет ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Стратегия формирования ID
    @Column(name = "id")
    private Long id;
    private String Email;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime DateTime;
    private Integer GrandSum;
    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;
    public Order(){};
}
