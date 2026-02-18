package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;


public class EntityClassList {

    @JacksonXmlElementWrapper(localName = "entities")
    @JsonProperty("entity")
    public List<EntityClass> entityClassList;
    
}
