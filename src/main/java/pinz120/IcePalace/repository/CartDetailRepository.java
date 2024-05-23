package pinz120.IcePalace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pinz120.IcePalace.model.CartDetail;

@Repository
public interface CartDetailRepository extends CrudRepository<CartDetail, Long> {
}
