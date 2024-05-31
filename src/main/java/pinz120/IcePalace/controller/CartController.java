package pinz120.IcePalace.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pinz120.IcePalace.model.*;
import pinz120.IcePalace.service.OrderDetailService;
import pinz120.IcePalace.service.OrderService;
import pinz120.IcePalace.service.ProductService;
import pinz120.IcePalace.service.ScheduleService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CartController {
    private final ScheduleService scheduleService;
    private final OrderDetailService orderDetailService;
    private final OrderService orderService;
    private final ProductService productService;
    @Autowired
    public CartController(ScheduleService scheduleService, OrderDetailService orderDetailService, OrderService orderService, ProductService productService) {
        this.scheduleService = scheduleService;
        this.orderDetailService = orderDetailService;
        this.orderService = orderService;
        this.productService = productService;
    }

    @GetMapping("/Checkout")
    public String CreateOrderForm(Model model, OrderDTO orderDTO){
        List<Schedule> schedules = (List<Schedule>) scheduleService.findAll();
        model.addAttribute("schedules", schedules);
        model.addAttribute(orderDTO);
        return "/Checkout";
    }
    @PostMapping("/Checkout")
    public String CreateOrder(@ModelAttribute OrderDTO orderDTO,HttpSession session ){
        List<Cart> cart = (List<Cart>) session.getAttribute("cart");

        if((orderDTO.getEmail() != null)&&(orderDTO.getDateTime() != null)){

            List<OrderDetail> orderDetailList = new ArrayList<>();
            OrderDetail orderDetail = new OrderDetail();
            for(Cart item:cart){
                orderDetail.setQuantity(item.Quantity);
                orderDetail.setPrice(item.Price);
                orderDetail.setDateTime(orderDTO.getDateTime());
                orderDetail.setTotalSum(item.getTotalSum());
                orderDetail.setProduct(item.Product.getId());
                orderDetail.setGrandSum(item.getGrandSum());

                orderDetailService.createOrderDetail(orderDetail);
            }
            Order order = new Order();
            order.setEmail(orderDTO.getEmail());
            order.setDateTime(orderDTO.getDateTime());
            order.setGrandSum(orderDetail.getGrandSum());
            order.setOrderDetailList(orderDetailService.findAll());
            orderService.createOrder(order);
            return "redirect:/Home";
        }
        return "redirect:/Checkout";
      //  else  return "redirect:/OrderFailure";
    }
    private int exists(Long id, List<Cart> cart){
        for (int i=0; i < cart.size();i++){
            if(cart.get(i).Product.getId() == id){
                return i;
            }
        }
        return -1;
    }
}
