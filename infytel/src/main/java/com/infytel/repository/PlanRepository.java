package com.infytel.repository;

import com.infytel.dto.PlanDTO;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class PlanRepository {

    private List<PlanDTO> plans;

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

    public List<PlanDTO> fetchPlans() {
        return plans;
    }

    public List<PlanDTO> plansLocalRate(List localRates) {
        List<PlanDTO> plansResponse = new ArrayList<>();
        Iterator it = localRates.iterator();
        while (it.hasNext()) {
            int rate = Integer.parseInt((String) it.next());
            for (PlanDTO plan : plans) {
                if (rate == plan.getLocalRate())
                    plansResponse.add(plan);
            }
        }
        return plansResponse;
    }

    public PlanDTO fetchPlanById(int planId) {
        return plans.stream().filter(x -> x.getPlanId() == planId).findFirst().orElse(plans.get(0));
    }

    public Map<String, Integer> fetchPlanByIdv2(int planId) {
        Map<String, Integer> rates = new HashMap<>();
        PlanDTO planDTO = plans.stream().filter(x -> x.getPlanId() == planId).findFirst().orElse(plans.get(0));
        rates.put("localRates", planDTO.getLocalRate());
        rates.put("nationalRate", planDTO.getNationalRate());
        return rates;
    }
}
