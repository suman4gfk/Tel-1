package com.infytel.dto;

import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlSeeAlso({PlanDTO.class, Product.class})
public class EntityList<T> {
    private List<T> listOfEntityObjects;

    public EntityList() {
        listOfEntityObjects = new ArrayList<>();
    }

    public EntityList(List<T> listOfEntityObjects) {
        this.listOfEntityObjects = listOfEntityObjects;
    }

    @XmlAnyElement
    public List<T> getItems() {
        return listOfEntityObjects;
    }
}
