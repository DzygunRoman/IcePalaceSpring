package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "CartDetail")
public class CartDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Quantity;
    private int UnitPrice;

    @OneToOne
    @JoinColumn(name = "products_id")
    private Product product;
    @OneToOne
    @JoinColumn(name = "ShoppingCart_id")
    private ShoppingCart shoppingCart;

}
