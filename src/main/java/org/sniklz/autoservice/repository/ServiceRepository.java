package org.sniklz.autoservice.repository;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> getServicesByIdIn(Set<Long> ids);
}
