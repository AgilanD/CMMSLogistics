package cmms.Logistics.common.entity.repository;

import cmms.Logistics.common.entity.Plants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantsRepository extends JpaRepository<Plants,Long> {
}
