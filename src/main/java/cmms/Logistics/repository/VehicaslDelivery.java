package cmms.Logistics.repository;

import cmms.Logistics.entity.VehicalDelivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VehicaslDelivery extends JpaRepository<VehicalDelivery,Long> {

}
