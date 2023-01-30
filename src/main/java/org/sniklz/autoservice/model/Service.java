package org.sniklz.autoservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import lombok.Data;

@Data
@Entity
@Table (name = "services")
public class Service {
    @Id
    @GeneratedValue(generator = "services_id_seq",
            strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "services_id_seq",
            sequenceName = "services_id_seq",
            allocationSize = 1)
    private Long id;
    @ManyToOne
    private Order order;
    @ManyToOne
    private Master master;
    private BigDecimal cost;
    @Enumerated (EnumType.STRING)
    private ServiceType serviceType;
    @Enumerated (EnumType.STRING)
    private ServiceStatus status;

    public enum ServiceType {
        DEFAULT("Default"),
        DIAGNOSTIC("Diagnostic");

        private String value;

        ServiceType(String value) {
            this.value = value;
        }
    }

    public enum ServiceStatus {
        PAYED("Payed"),
        NOT_PAYED("Not_Payed");

        private String value;

        ServiceStatus(String value) {
            this.value = value;
        }
    }
}
