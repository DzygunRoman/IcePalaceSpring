package pinz120.IcePalace.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pinz120.IcePalace.model.Cart;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.model.Schedule;
import pinz120.IcePalace.service.ProductService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class UserProductController {
    private final ProductService productService;

    public UserProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping("UserProduct")
    public String findAll(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products",products);
        return "UserProduct";
    }
    @GetMapping("/buy/{id}")
    public String buy(@PathVariable("id")Long id, HttpSession session,Model model){
        Optional<Product> products = productService.findById(id);
        if(products.isEmpty()){
            return "redirect:/UserProduct";
        }
        Integer TotalSum = 0;
        if(session.getAttribute("cart") == null){
            List<Cart> cart = new ArrayList<Cart>();
            cart.add(new Cart(products.get(),1,products.get().getPrice(),products.get().getSumma(),products.get().getGrandSum()));
            session.setAttribute("cart",cart);
        } else{
            List<Cart> cart = (List<Cart>) session.getAttribute("cart");
            int index = this.exists(id, cart);
            if (index == -1) {
                cart.add(new Cart(products.get(),1,products.get().getPrice(),products.get().getSumma(),products.get().getGrandSum()));
            }else{
                if(cart.get(index).getTotalSum() == null){
                    cart.get(index).setTotalSum(0);
                }
                if(cart.get(index).getGrandSum() == null){
                    cart.get(index).setGrandSum(0);
                }
                cart.get(index).setQuantity(cart.get(index).Quantity+1);
                cart.get(index).setTotalSum(products.get().getPrice()*cart.get(index).Quantity);
                int x = 0;
                for(Cart item : cart){
                    x += item.getTotalSum();
                    item.setGrandSum(x);
                }
            }
            model.addAttribute("cart",cart);
        }
        return "redirect:/UserProduct";
    }
    private int exists(Long id, List<Cart> cart){
        for (int i=0; i < cart.size();i++){
            if(cart.get(i).Product.getId() == id){
                return i;
            }
        }
        return -1;
    }
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id,Model model, HttpSession session) {
        List<Cart> carts = (List<Cart>) session.getAttribute("cart");
        int index = this.exists(id, carts);
        if (carts.get(index).Quantity==1){
            carts.remove(index);
        }
        else {
            int quint=carts.get(index).Quantity;
            int sum=carts.get(index).TotalSum - carts.get(index).Price;
            int quantity = quint - 1;
            int grandTotal = carts.get(carts.size()-1).GrandSum - carts.get(index).Price;
            carts.get(index).setQuantity(quantity);
            carts.get(index).setTotalSum(sum);
            carts.get(carts.size()-1).setGrandSum(grandTotal);
        }
        model.addAttribute("carts", carts);
        return "redirect:/Cart";
    }
    @GetMapping("/addItem/{id}")
    public String addItem(@PathVariable("id") Long id, Model model, HttpSession session){
        List<Cart> carts = (List<Cart>) session.getAttribute("cart");
        int index = this.exists(id, carts);
        int quint=carts.get(index).Quantity;
        int sum = carts.get(index).TotalSum + carts.get(index).Price;
        int quantity = quint + 1;
        int grandTotal = carts.get(carts.size()-1).GrandSum + carts.get(index).Price;
        carts.get(index).setQuantity(quantity);
        carts.get(index).setTotalSum(sum);
        carts.get(carts.size()-1).setGrandSum(grandTotal);
        model.addAttribute("carts", carts);
        return "redirect:/Cart";
    }
    @GetMapping(value="/Cart")
    public String index(Model model,HttpSession session) {
        if (session.getAttribute("cart") == null) {
            return "/CartEmpty";
        } else {
            List<Cart> carts = (List<Cart>) session.getAttribute("cart");
            model.addAttribute("carts", carts);
            return "/Cart";
        }
    }
}
