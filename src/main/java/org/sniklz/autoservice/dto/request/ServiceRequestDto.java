package org.sniklz.autoservice.dto.request;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ServiceRequestDto {
    private Long orderId;
    private Long masterId;
    private BigDecimal cost;
    private String serviceType;
}
