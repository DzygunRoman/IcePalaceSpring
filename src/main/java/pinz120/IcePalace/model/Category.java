package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Entity
@Table(name = "categories")
public class Category {
    @Id//аннотация указывает что данное поле будет ID
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Стратегия формирования ID
    private Long id;//id
    private String categoryName;//название категории
    private String categoryDescription;//описание категории
    private String Slug;//слаг

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}