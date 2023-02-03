package org.sniklz.autoservice.service;

import java.math.BigDecimal;
import org.sniklz.autoservice.model.Master;

public interface MasterService extends DefaultService<Master> {

    Master getMasterById(Long id);

    BigDecimal calculateMasterSalary(Long masterId);

}
