package cmms.Logistics.common.entity.repository;

import cmms.Logistics.common.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {
}
