package cmms.logistics.common.entity.repository;

import cmms.logistics.common.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee ,Long> {
}
