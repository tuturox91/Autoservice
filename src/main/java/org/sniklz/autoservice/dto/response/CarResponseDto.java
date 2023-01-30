package org.sniklz.autoservice.dto.response;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String mark;
    private String model;
    private Long productionYear;
    private String number;
    private Long carOwnerId;
}
