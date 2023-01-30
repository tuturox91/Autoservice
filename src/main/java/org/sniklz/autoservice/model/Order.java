package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(generator = "orders_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orders_id_seq",
            sequenceName = "orders_id_seq",
            allocationSize = 1)
    private Long id;
    @ManyToOne
    private Car car;
    private String description;
    @CreatedDate
    private LocalDateTime acceptOrderTime;
    @ManyToMany
    private List<Service> services;
    @ManyToMany
    private List<Product> products;
    @Enumerated (EnumType.STRING)
    private OrderStatus orderStatus;
    private BigDecimal resultCost;
    private LocalDateTime completeTime;

    public enum OrderStatus {
        ACCEPTED("Accepted"),
        IN_PROCESS("In_Process"),
        COMPLETED("Completed"),
        NOT_COMPLETED("Not_Completed");

        private String value;

        OrderStatus(String value) {
            this.value = value;
        }
    }
}
