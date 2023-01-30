package org.sniklz.autoservice.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.model.Service;

import java.math.BigDecimal;

@Data
public class ServiceResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private String serviceType;
    private BigDecimal cost;
    private String status;
}
