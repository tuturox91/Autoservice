package org.sniklz.autoservice.dto.request;

import lombok.Data;
import org.sniklz.autoservice.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class OrderRequestDto {
    private Long carId;
    private String description;
    private List<Long> servicesIds;
    private List<Long> productsIds;
    private LocalDateTime acceptOrderTime = LocalDateTime.now();
    private String orderStatus = "accepted";
    private BigDecimal resultCost = BigDecimal.ZERO;
}
