package pinz120.IcePalace.service;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.OrderDetail;
import pinz120.IcePalace.repository.OrderDetailRepository;
import pinz120.IcePalace.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailService(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }
    public Optional<OrderDetail> findById(Long id){
        return orderDetailRepository.findById(id);
    }
    public List<OrderDetail> findAll(){
        return (List<OrderDetail>)orderDetailRepository.findAll();
    }
    public void createOrderDetail(OrderDetail orderDetail){
        orderDetailRepository.save(orderDetail);
    }
    public void deleteById(Long id){
        orderDetailRepository.deleteById(id);
    }
}
