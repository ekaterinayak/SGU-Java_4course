package mirzoeva.jpa.repository;

import mirzoeva.jpa.model.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author mirzoeva
 */
@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Long> {

    List<CustomerGroup> findByName(String name);
}
