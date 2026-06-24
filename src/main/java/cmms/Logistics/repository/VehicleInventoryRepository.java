package cmms.Logistics.repository;

import cmms.Logistics.entity.VehicleInventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleInventoryRepository extends JpaRepository<VehicleInventory,Long> {

}
