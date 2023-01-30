package org.sniklz.autoservice.repository;

import org.sniklz.autoservice.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> getServicesByIdIn(Set<Long> ids);
}
