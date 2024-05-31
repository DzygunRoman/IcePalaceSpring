package pinz120.IcePalace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pinz120.IcePalace.model.Order;
import pinz120.IcePalace.model.Product;
import pinz120.IcePalace.service.OrderService;

import java.util.List;

@Controller
public class OrderAdminController {
    private final OrderService orderService;

    public OrderAdminController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/IndexOrder")
    public String findAll(Model model){
        List<Order> orders = (List<Order>) orderService.findAll();
        model.addAttribute("orders", orders);
        return "IndexOrder";
    }
}
