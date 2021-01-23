package com.infytel.service;

import com.infytel.dto.PlanDTO;
import com.infytel.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public List<PlanDTO> fetchPlans() {
        return planRepository.fetchPlans();
    }

    public List<PlanDTO> plansLocalRate(List localRates) {
        return planRepository.plansLocalRate(localRates);
    }

    public PlanDTO fetchPlanById(String planId) {
        return planRepository.fetchPlanById(Integer.parseInt(planId));
    }

    public Map<String, Integer> fetchPlanByIdv2(String planId) {
        return planRepository.fetchPlanByIdv2(Integer.parseInt(planId));
    }
}
