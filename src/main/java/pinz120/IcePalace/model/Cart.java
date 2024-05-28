package pinz120.IcePalace.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Data
public class Cart {
    public Long Id;
    public Product Product;
    public int Quantity;
    public Integer Price;
    public Integer TotalSum;
    public Integer GrandSum;

    public Cart(pinz120.IcePalace.model.Product product, int quantity, Integer price, Integer totalSum, Integer grandSum) {
        Product = product;
        Quantity = quantity;
        Price = price;
        TotalSum = totalSum;
        GrandSum = grandSum;
    }

   // int totalCost = 0;

   // public Cart(int totalCost) {
   // }

   // public Cart(Cart cart) {
   // }

   // public Cart GetGrandSum() {
   //     List<Cart> cartList = new ArrayList<>();
   //     int GrandSum = 0;
   //     for (int i = 1; i < cartList.size(); i++) {
   //         totalCost += cartList.get(i).Quantity * cartList.get(i).Price;
   //     }
   //     Cart GetGrandSum = new Cart(totalCost);
   //     return GetGrandSum;
   // }
}


