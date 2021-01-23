package com.infytel.controller;

import com.infytel.dto.CallDetailsDTO;
import com.infytel.service.CallDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.joda.LocalDateParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/calldetails")
public class CallDetailsController {
    @Autowired
    private CallDetailsService callDetailsService;

    @GetMapping
    public List<CallDetailsDTO> fetchCallDetails(@RequestParam("calledBy") long calledBy,
                                                 @RequestParam("calledOn") String calledOn) {
        return callDetailsService.fetchCallDetails(calledBy,
                LocalDate.parse(calledOn, DateTimeFormatter.ofPattern("MM-dd-yyyy")));
    }

}
