package org.sniklz.autoservice.dto.request;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class ProductRequestDto {
    private String name;
    private BigDecimal cost;
}
