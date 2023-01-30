package org.sniklz.autoservice.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Long> completedOrderIds;

}
