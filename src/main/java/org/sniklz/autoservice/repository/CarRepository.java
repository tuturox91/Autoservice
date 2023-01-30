package org.sniklz.autoservice.repository;

import org.sniklz.autoservice.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> getCarsByIdIn(Set<Long> id);
}
