package com.infy.infytel2.repository;

import com.infy.infytel2.dto.PlanDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PlanRepository {
    private List<PlanDTO> plans;

    // Populating a list of plans
    @PostConstruct
    public void populatePlans() {
        plans = new ArrayList<>();
        PlanDTO plan1 = new PlanDTO();
        plan1.setPlanId(1);
        plan1.setPlanName("Simple");
        plan1.setLocalRate(3);
        plan1.setNationalRate(5);
        plans.add(plan1);
        PlanDTO plan2 = new PlanDTO();
        plan2.setPlanId(2);
        plan2.setPlanName("Medium");
        plan2.setLocalRate(5);
        plan2.setNationalRate(8);
        plans.add(plan2);
    }

    public PlanDTO fetchPlanById(int planId) {
        Optional<PlanDTO> optionalPlanDTO = plans.stream().filter(x -> x.getPlanId() == planId).findFirst();
        return optionalPlanDTO.orElse(plans.get(0));
    }
}
