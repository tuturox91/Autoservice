package org.sniklz.autoservice.dto.response;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductResponseDto {
    private Long id;
    private String name;
    private BigDecimal cost;
}
