package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlText;

public class EntityClass {
    @JacksonXmlText
    @JsonProperty("kto")
    public String kto;

    @JacksonXmlProperty(isAttribute = true, localName = "Hkto")
    @JsonProperty("hkto") 
    public String hkto;
}