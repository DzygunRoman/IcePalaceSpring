package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Quantity;
    private int UnitPrice;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime DateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Order_id")
    private Order order;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Products_id")
    private Product product;


}
