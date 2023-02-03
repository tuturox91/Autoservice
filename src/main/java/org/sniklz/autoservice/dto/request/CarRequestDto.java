package org.sniklz.autoservice.dto.request;

import lombok.Data;

@Data
public class CarRequestDto {
    private String model;
    private String mark;
    private Long productionYear;
    private String number;
    private Long carOwner;
}
