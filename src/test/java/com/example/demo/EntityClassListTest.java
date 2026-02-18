package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tools.jackson.databind.json.JsonMapper;
import tools.jackson.dataformat.xml.XmlMapper;

import static tools.jackson.databind.DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT;
import static tools.jackson.databind.cfg.DateTimeFeature.WRITE_DATES_AS_TIMESTAMPS;

class EntityClassListTest {
    XmlMapper xmlMapper = XmlMapper.builder()
            .defaultUseWrapper(false)
            .disable(WRITE_DATES_AS_TIMESTAMPS)
            .enable(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .build();

    JsonMapper jsonMapper = JsonMapper.builder()
            .disable(WRITE_DATES_AS_TIMESTAMPS)
            .enable(ACCEPT_EMPTY_STRING_AS_NULL_OBJECT)
            .changeDefaultPropertyInclusion(incl -> incl.withValueInclusion(JsonInclude.Include.NON_NULL))
            .build();
    
    EntityClassList entityClassList;

    String xmlString =
            """
                    <?xml version="1.0" encoding="UTF-8"?>
                    <EntityclassList>
                        <entities>
                            <kto Hkto="6543210000">4561230000</kto>
                            <kto Hkto="6543210000">5678910012</kto>
                            <kto Hkto="">5678910013</kto>
                            <kto Hkto="654321">567891</kto>
                            <kto>5678910014</kto>
                            <kto>567891</kto>
                        </entities>
                    </EntityclassList>""";

    @BeforeEach
    void setup() {
        entityClassList = xmlMapper.readValue(xmlString, EntityClassList.class);
    }

    @Test
    void testXmlDeser() {
        Assertions.assertNotNull(entityClassList);
    }
}
