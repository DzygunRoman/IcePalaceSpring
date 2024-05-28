package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Data
@Entity
@Table(name="Order")
public class Order {
    @Id//аннотация указывает что данное поле будет ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Стратегия формирования ID
    @Column(name = "id")
    private Long id;
    private String UserId = "User";

    private boolean IsDeleted = false;
    private String Email;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime DateTime;

    @OneToMany(mappedBy = "OrderDetail")
    private List<OrderDetail> OrderDetail;

}
