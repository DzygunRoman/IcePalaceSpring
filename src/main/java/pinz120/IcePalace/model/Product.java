package pinz120.IcePalace.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


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
    private Integer Quantity;
    private Integer Summa;
    private Integer GrandSum;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;
   // @OneToOne(mappedBy = "product", cascade = CascadeType.ALL,optional = false, fetch = FetchType.EAGER)
  //  private OrderDetail orderDetail;
    public Product(Long id, String Name){this.id = id;}

    public Product(){}
}
