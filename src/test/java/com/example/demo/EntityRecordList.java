package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.List;

public record EntityRecordList(@JacksonXmlElementWrapper(localName = "entities")
                               @JsonProperty("entity")
                               List<EntityRecord> entityRecordList) {
}
