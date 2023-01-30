package org.sniklz.autoservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class CarOwnerRequestDto {
    private List<Long> carIds;
    private List<Long> orderIds;
}
