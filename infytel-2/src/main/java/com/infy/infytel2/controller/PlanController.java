package com.infy.infytel2.controller;

import com.infy.infytel2.dto.PlanDTO;
import com.infy.infytel2.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plans")
public class PlanController {

    @Autowired
    private PlanService planService;

    @GetMapping("/{planId}")
    public PlanDTO fetchPlanById(@PathVariable("planId") int planId) {

        return planService.fetchPlanById(planId);
    }
}
