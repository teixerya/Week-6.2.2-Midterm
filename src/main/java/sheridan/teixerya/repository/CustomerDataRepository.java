package sheridan.teixerya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerDataRepository extends JpaRepository<CustomerEntity, Integer> {
}
