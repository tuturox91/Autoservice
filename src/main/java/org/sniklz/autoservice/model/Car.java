package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "cars")
public class Car {
    @Id
    @GeneratedValue(generator = "cars_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "cars_id_seq",
            sequenceName = "cars_id_seq",
            allocationSize = 1)
    private Long id;
    private String mark;
    private String model;
    private Long productionYear;
    private String number;
    @ManyToOne
    private CarOwner carOwner;
}
