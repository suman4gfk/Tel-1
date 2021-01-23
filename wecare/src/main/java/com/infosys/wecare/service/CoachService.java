package com.infosys.wecare.service;

import com.infosys.wecare.dto.CoachDTO;
import com.infosys.wecare.dto.LoginDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoachService {

    public String createCoach(CoachDTO coachDTO) {
        return "";
    }

    public boolean loginCoach(LoginDTO loginDTO) {
        return false;
    }

    public CoachDTO getCoachProfile(String coachId) {
        return null;
    }

    public List<CoachDTO> showAllCoaches() {
        return null;
    }
}
