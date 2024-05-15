package pinz120.IcePalace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pinz120.IcePalace.model.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
