package com.infosys.wecare.controller;

import com.infosys.wecare.dto.BookingDTO;
import com.infosys.wecare.dto.CoachDTO;
import com.infosys.wecare.dto.ErrorMessage;
import com.infosys.wecare.dto.LoginDTO;
import com.infosys.wecare.service.CoachService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/coaches")
@Validated
public class CoachRestController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    public CoachService coachService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity createCoach(@Valid @RequestBody CoachDTO coachDTO, Errors errors) {
        String response = "";
        if (errors.hasErrors()) {
            response = errors.getAllErrors()
                    .stream()
                    .map(ObjectError::getObjectName)
                    .collect(Collectors.joining(","));
            ErrorMessage errorMessage = new ErrorMessage();
            errorMessage.setMessage(response);
            return ResponseEntity.ok(errorMessage);
        } else {
            response = coachService.createCoach(coachDTO);
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }
    }

    @GetMapping("/login")
    public ResponseEntity<Boolean> loginCoach(@Valid @RequestBody LoginDTO loginDTO) {
        return null;
    }

    @GetMapping("/{coachId}")
    public ResponseEntity<CoachDTO> getCoachProfile(@PathVariable("coachId") String coachId) {
        return null;
    }

    @GetMapping("/all")
    public List<CoachDTO> showAllCoaches() {
        return null;
    }

    @GetMapping("/booking/{coachId}")
    public List<BookingDTO> showMySchedule(@PathVariable("/coachId") String coachId) {
        return null;
    }
}
