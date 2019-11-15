package com.iadmin.ui.extend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iadmin.ui.exception.MergeException;
import com.iadmin.ui.model.*;
import com.iadmin.ui.service.impl.DefaultRegistryService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExtendingTest.Config.class})
public class ExtendingTest {

    @Autowired
    private DefaultRegistryService defaultRegistryService;

    private Registry extendRegistry;

    @Before
    public void setup() throws IOException, MergeException {
        extendRegistry = defaultRegistryService.loadRegistries()
                .stream()
                .filter(registry -> registry.getCode().equals("extendTestRegistry"))
                .findFirst()
                .orElseThrow(IOException::new);
    }


    @Test
    public void withoutMerge() throws IOException {
        Presentation presentation = getPresentationByCode("techiesPresentation");
        ListProjection projection = getListProjectionByCode(presentation, "abstractMineListProjection");
        assertEquals(1, projection.getActions().size());
        assertEquals("hide", projection.getActions().get(0).getCode());
    }

    @Test
    public void simpleMerge() throws IOException {
        Presentation presentation = getPresentationByCode("linaPresentation");
        ListProjection projection = getListProjectionByCode(presentation, "linaListProjection");
        List<Action> actions = projection.getActions();
        assertEquals(5, actions.size());
        assertEquals("api/heroes/info", projection.getInfoUrl());
        assertEquals("spawn", actions.get(0).getCode());
        assertEquals("move", actions.get(1).getCode());
        assertEquals("dragonFire", actions.get(2).getCode());
        assertEquals("fireStun", actions.get(3).getCode());
        assertEquals("lagunaBlade", actions.get(4).getCode());
    }

    @Test
    public void doubleMerge() throws IOException {
        Presentation presentation = getPresentationByCode("arcWardenPresentation");
        ListProjection projection = getListProjectionByCode(presentation, "arcWardenCopyListProjection");
        List<Action> actions = projection.getActions();
        assertEquals(4, actions.size());
        assertEquals("api/heroes/arcWarden/info", projection.getInfoUrl());
        assertEquals("spawn", actions.get(0).getCode());
        assertEquals("move", actions.get(1).getCode());
        assertEquals("sphere", actions.get(2).getCode());
        assertEquals("vanish", actions.get(3).getCode());
    }

    @Test
    public void lastListProjectionTest() throws IOException {
        Presentation presentation = getPresentationByCode("arcWardenPresentation");
        ListProjection projection = getListProjectionByCode(presentation, "lastProjection");
        List<Action> actions = projection.getActions();
        List<ListField> fields = projection.getFields();
        assertEquals(3,fields.size());
        assertEquals(4, actions.size());
        assertEquals("spawn", actions.get(0).getCode());
        assertEquals("move", actions.get(1).getCode());
        assertEquals("sphere", actions.get(2).getCode());
        assertEquals("vanish", actions.get(3).getCode());
    }

    @Test
    public void testFormInheritance() throws IOException {
        Presentation presentation = getPresentationByCode("arcWardenPresentation");
        FormProjection projection = getFormProjectionByCode(presentation, "arcWardenFromProjection");
        List<FormField> fields = projection.getFields();
        assertEquals(2,fields.size());

    }

    private FormProjection getFormProjectionByCode(Presentation presentation, String code) throws IOException {
        return presentation.getFormProjections()
                .stream()
                .filter(registry -> registry.getCode().equals(code))
                .findFirst()
                .orElseThrow(IOException::new);
    }


    private Presentation getPresentationByCode(String code) throws IOException {
        return extendRegistry.getPresentations()
                .stream()
                .filter(registry -> registry.getCode().equals(code))
                .findFirst()
                .orElseThrow(IOException::new);
    }

    private ListProjection getListProjectionByCode(Presentation presentation, String code) throws IOException {
        return presentation.getProjections()
                .stream()
                .filter(registry -> registry.getCode().equals(code))
                .findFirst()
                .orElseThrow(IOException::new);
    }

    @Configuration
    @ComponentScan("com.iadmin.ui")
    public static class Config {

        @Bean
        public ObjectMapper objectMapper(){
            return new ObjectMapper();
        }
    }

}
