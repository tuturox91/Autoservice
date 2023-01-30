package org.sniklz.autoservice.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class CarOwnerResponseDto {
    private Long id;
    private List<Long> carIds;
    private List<Long> orderIds;
}
