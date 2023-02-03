package org.sniklz.autoservice.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class CarOwnerResponseDto {
    private Long id;
    private List<Long> carIds;
    private List<Long> orderIds;
}
