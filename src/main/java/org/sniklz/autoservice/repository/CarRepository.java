package org.sniklz.autoservice.repository;

import java.util.List;
import java.util.Set;
import org.sniklz.autoservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getCarsByIdIn(Set<Long> id);
}
