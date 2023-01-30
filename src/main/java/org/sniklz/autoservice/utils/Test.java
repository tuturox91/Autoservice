package org.sniklz.autoservice.utils;

import jakarta.annotation.PostConstruct;
import org.sniklz.autoservice.model.Master;
import org.sniklz.autoservice.repository.MasterRepository;
import org.springframework.stereotype.Component;

//@Component
public class Test {

    private final MasterRepository masterRepository;

    public Test(MasterRepository masterRepository) {
        this.masterRepository = masterRepository;
    }

    //@PostConstruct
    public void inject() {
        Master master = new Master();
        master.setCompletedOrders(null);
        master.setFullName("Vlad Muzyka Pavlovich");
        masterRepository.save(master);
    }
}
