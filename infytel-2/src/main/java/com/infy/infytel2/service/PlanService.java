package com.infy.infytel2.service;

import com.infy.infytel2.dto.PlanDTO;
import com.infy.infytel2.repository.PlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlanService {
    @Autowired
    private PlanRepository planRepository;

    public PlanDTO fetchPlanById(int planId) {
        return planRepository.fetchPlanById(planId);
    }
}
