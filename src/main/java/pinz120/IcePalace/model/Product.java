package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Objects;

@NoArgsConstructor
@Data
@Entity
@Table(name="products")
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;

}
