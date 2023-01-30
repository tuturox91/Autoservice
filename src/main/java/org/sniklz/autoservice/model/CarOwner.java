package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table (name = "carOwners")
public class CarOwner {
    @Id
    @GeneratedValue(generator = "car_owners_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "car_owners_id_seq",
            sequenceName = "car_owners_id_seq",
            allocationSize = 1)
    private Long id;
    @ManyToMany
    private List<Car> cars;
    @ManyToMany
    private List<Order> orders;

}
