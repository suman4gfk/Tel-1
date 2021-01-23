package com.infytel.controller;

import com.infytel.dto.EntityList;
import com.infytel.dto.PlanDTO;
import com.infytel.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private EntityList<PlanDTO> plans;
    @Autowired
    private PlanService planService;

    @GetMapping(produces = {"application/xml"})
    public EntityList<PlanDTO> fetchPlans() {
        plans = new EntityList<>(planService.fetchPlans());
        return plans;
    }

    @GetMapping(value = "/{planId}", params = "version=1", produces = {"application/json"})
    public PlanDTO fetchPlanById(@PathVariable("planId") String planId) {
        return planService.fetchPlanById(planId);
    }

    @GetMapping(value = "/{planId}", params = "version=2")
    public Map<String, Integer> fetchPlanByIdv2(@PathVariable("planId") String planId) {
        return planService.fetchPlanByIdv2(planId);
    }

    @GetMapping(value = "/{query}/plan", produces = {"application/json", "application/xml"})
    public EntityList<PlanDTO> plansLocaleRate(@MatrixVariable(pathVar = "query") Map<String, List<Integer>> map) {
        Set<String> keysLocalRates = map.keySet();
        List localRates = new ArrayList();
        for (String key : keysLocalRates) {
            localRates.addAll(map.get(key));
        }
        plans = new EntityList<>(planService.plansLocalRate(localRates));
        return plans;
    }

}
