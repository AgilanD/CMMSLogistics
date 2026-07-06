package cmms.logistics.repository;

import cmms.logistics.entity.VehicalDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicalDeliveryRepository extends JpaRepository<VehicalDelivery,Long> {

}
