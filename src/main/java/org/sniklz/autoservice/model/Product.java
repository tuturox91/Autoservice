package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table (name = "products")
public class Product {
    @Id
    @GeneratedValue(generator = "products_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "products_id_seq",
            sequenceName = "products_id_seq",
            allocationSize = 1)
    private Long id;
    private String name;
    private BigDecimal cost;
}
