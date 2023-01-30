package org.sniklz.autoservice.service;

import org.sniklz.autoservice.model.Master;

import java.math.BigDecimal;

public interface MasterService extends DefaultService<Master> {

    Master getMasterById(Long id);

    BigDecimal calculateMasterSalary(Long masterId);

}
