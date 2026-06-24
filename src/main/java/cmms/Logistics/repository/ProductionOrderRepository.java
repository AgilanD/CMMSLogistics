package cmms.Logistics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cmms.Logistics.entity.ProductionOrder;

public interface ProductionOrderRepository extends JpaRepository<ProductionOrder, Long> {

}
