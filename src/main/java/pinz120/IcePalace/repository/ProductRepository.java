package pinz120.IcePalace.repository;

import org.springframework.data.repository.CrudRepository;
import pinz120.IcePalace.model.Category;
import pinz120.IcePalace.model.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
