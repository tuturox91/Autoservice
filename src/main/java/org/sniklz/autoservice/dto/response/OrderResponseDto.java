package org.sniklz.autoservice.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String description;
    private LocalDateTime acceptOrderTime;
    private List<Long> servicesIds;
    private List<Long> productsIds;
    private String orderStatus;
    private BigDecimal resultCost;
    private LocalDateTime completeTime;
}
