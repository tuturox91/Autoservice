package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "masters")
public class Master {
    @Id
    @GeneratedValue(generator = "masters_id_seq ",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "masters_id_seq ",
            sequenceName = "masters_id_seq ",
            allocationSize = 1)
    private Long id;
    private String fullName;
    @ManyToMany
    private List<Order> completedOrders;
}
