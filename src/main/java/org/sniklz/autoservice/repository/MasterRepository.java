package org.sniklz.autoservice.repository;

import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MasterRepository extends JpaRepository<Master, Long> {
}
