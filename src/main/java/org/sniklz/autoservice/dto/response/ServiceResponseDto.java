package org.sniklz.autoservice.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ServiceResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private String serviceType;
    private BigDecimal cost;
    private String status;
}
