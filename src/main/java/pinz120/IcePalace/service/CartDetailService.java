package pinz120.IcePalace.service;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.CartDetail;
import pinz120.IcePalace.repository.CartDetailRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartDetailService {
    private final CartDetailRepository cartDetailRepository;

    public CartDetailService(CartDetailRepository cartDetailRepository) {
        this.cartDetailRepository = cartDetailRepository;
    }
    public Optional<CartDetail> findById(Long id ){
        return cartDetailRepository.findById(id);
    }
    public List<CartDetail> findAll(){
        return (List<CartDetail>) cartDetailRepository.findAll();
    }
    public void createCartDetail(CartDetail cartDetail){
        cartDetailRepository.save(cartDetail);
    }
    public void deletebyId(Long id){
        cartDetailRepository.deleteById(id);
    }
}
