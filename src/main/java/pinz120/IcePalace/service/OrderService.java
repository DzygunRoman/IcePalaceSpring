package pinz120.IcePalace.service;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.Order;
import pinz120.IcePalace.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
    public Optional<Order> findById(Long id){
        return orderRepository.findById(id);
    }
    public List<Order> findAll(){
        return (List<Order>)orderRepository.findAll();
    }
    public void createOrder(Order order){
        orderRepository.save(order);
    }
    public void deleteById(Long id){
        orderRepository.deleteById(id);
    }
}
