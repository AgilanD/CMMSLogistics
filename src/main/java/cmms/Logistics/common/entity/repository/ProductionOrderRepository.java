package cmms.Logistics.common.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cmms.Logistics.common.entity.ProductionOrder;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {

}
