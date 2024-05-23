package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String UserId = "1";
    private boolean IdDeleted = false;

    @OneToMany(mappedBy = "CartDetails")
    private List<Product> products;
}
