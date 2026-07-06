package cmms.logistics.common.entity.repository;

import cmms.logistics.common.entity.VehicleInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleInventoryRepository  extends JpaRepository<VehicleInventory,Long> {

}
