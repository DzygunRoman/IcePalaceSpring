package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name="Products")
public class Product {
    @Id//аннотация указывает что данное поле будет ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Стратегия формирования ID
    @Column(name = "id")
    private Long id;
    private String Name;
    private Integer price;
    private String Photo;
    private String Slug;
    private String Description;
    private Boolean available;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToOne(mappedBy = "OrderDetail")
    private OrderDetail orderDetail;

    public Product(Long id, String name, Integer price, String photo, String slug, String description, Boolean available, Category category) {
        this.id = id;
        Name = name;
        this.price = price;
        Photo = photo;
        Slug = slug;
        Description = description;
        this.available = available;
        this.category = category;
    }
}
