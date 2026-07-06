package cmms.logistics.common.entity.repository;

import cmms.logistics.common.entity.CarModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModuleRepository extends JpaRepository<CarModule ,Long> {

}
