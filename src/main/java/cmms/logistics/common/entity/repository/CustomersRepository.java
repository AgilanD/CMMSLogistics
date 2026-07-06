package cmms.logistics.common.entity.repository;

import cmms.logistics.common.entity.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomersRepository extends JpaRepository<Customers,Long> {


}
