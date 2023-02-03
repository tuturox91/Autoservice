package org.sniklz.autoservice.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class CarOwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
