package cmms.logistics.common.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cmms.logistics.common.entity.ProductionOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {

}
