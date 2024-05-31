package pinz120.IcePalace.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pinz120.IcePalace.model.OrderDetail;

@Repository
public interface OrderDetailRepository extends CrudRepository<OrderDetail,Long> {
}
