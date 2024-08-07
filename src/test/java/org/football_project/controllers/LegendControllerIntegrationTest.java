package org.football_project.controllers;

import org.football_project.dtos.AddLegendDto;
import org.football_project.entities.enums.PositionEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(
        username = "user"
)
public class LegendControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testViewLegends() throws Exception {
        mockMvc.perform(get("/legends/view-legends"))
                .andDo(print())
                .andExpect(view().name("view-legends"));
    }

    @Test
    void testAddLegend() throws Exception {
        mockMvc.perform(get("/legends/add-legend"))
                .andDo(print())
                .andExpect(view().name("add-legend"));
    }

    @Test
    void testDoAddLegend() throws Exception {
        AddLegendDto addLegendDto = new AddLegendDto();
        addLegendDto.setName("legend");
        addLegendDto.setAge(25);
        addLegendDto.setPosition(PositionEnum.DEFENDER);
        addLegendDto.setGoalsCount(25);
        addLegendDto.setAssistsCount(25);
        addLegendDto.setMatchesCount(25);

        mockMvc.perform(post("/legends/add-legend")
                        .param("legend", String.valueOf(addLegendDto))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

    @Test
    void testViewDeleteLegend() throws Exception {
        mockMvc.perform(get("/legends/delete-legend"))
                .andDo(print())
                .andExpect(view().name("delete-legend"));
    }

    @Test
    void testDeleteLegend() throws Exception {
        mockMvc.perform(delete("/legends/delete-legend/{name}","aaa")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

}
