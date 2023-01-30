package org.sniklz.autoservice.dto.request;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Service;

import java.math.BigDecimal;

@Data
public class ServiceRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal cost;
    private String serviceType;
}
