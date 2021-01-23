package com.infytel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@Data
@AllArgsConstructor
@XmlRootElement
public class PlanDTO {
    private int planId;
    private String planName;
    private int localRate;
    private int nationalRate;

    public PlanDTO() {
        super();
    }
}
