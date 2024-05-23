package pinz120.IcePalace.service;

import org.springframework.stereotype.Service;
import pinz120.IcePalace.model.ShoppingCart;
import pinz120.IcePalace.repository.ShoppingCartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;

    public ShoppingCartService(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }
    public Optional<ShoppingCart> findById(Long id){
        return shoppingCartRepository.findById(id);
    }
    public List<ShoppingCart> findAll(){
        return (List<ShoppingCart>) shoppingCartRepository.findAll();
    }
    public void createShoppingCart(ShoppingCart shoppingCart){
        shoppingCartRepository.save(shoppingCart);
    }
    public void deleteById(Long id) {
        shoppingCartRepository.deleteById(id);
    }
}
