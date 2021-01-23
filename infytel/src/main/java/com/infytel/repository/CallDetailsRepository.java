package com.infytel.repository;

import com.infytel.dto.CallDetailsDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CallDetailsRepository {

    List<CallDetailsDTO> callDetails = null;
    CallDetailsDTO cdd1 = null;
    CallDetailsDTO cdd2 = null;
    LocalDate cd = null;

    @PostConstruct
    private void populate() {
        callDetails = new ArrayList<>();
        cd = LocalDate.now();
        cdd1 = new CallDetailsDTO();
        cdd1.setCalledBy(12345);
        cdd1.setCalledTo(67890);
        cdd1.setCalledOn(cd);
        cdd1.setDuration(4);

        cdd2 = new CallDetailsDTO();
        cdd2.setCalledBy(34567);
        cdd2.setCalledTo(890123);
        cdd2.setCalledOn(cd);
        cdd2.setDuration(10);

        callDetails.add(cdd1);
        callDetails.add(cdd2);
    }

    public List<CallDetailsDTO> fetchCallDetails(long calledBy, LocalDate calledOn) {
        return callDetails.stream()
                .filter(x -> x.getCalledBy() == calledBy && x.getCalledOn().equals(calledOn))
                .collect(Collectors.toList());
    }
}
