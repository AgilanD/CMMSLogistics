package cmms.Logistics.common.entity.repository;

import cmms.Logistics.common.entity.CarModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModuleRepository extends JpaRepository<CarModule ,Long> {

}
