package org.football_project.controllers;

import org.football_project.dtos.AddFootballerDto;
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
public class FootballerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testViewFootballers() throws Exception {
        mockMvc.perform(get("/footballers/view-footballers"))
                .andDo(print())
                .andExpect(view().name("view-footballers"));
    }

    @Test
    void testAddFootballer() throws Exception {
        mockMvc.perform(get("/footballers/add-footballer"))
                .andDo(print())
                .andExpect(view().name("add-footballer"));
    }

    @Test
    void testDoAddFootballer() throws Exception {
        AddFootballerDto addFootballerDto = new AddFootballerDto();
        addFootballerDto.setName("footballer");
        addFootballerDto.setAge(25);
        addFootballerDto.setPosition(PositionEnum.DEFENDER);
        addFootballerDto.setGoalsCount(25);
        addFootballerDto.setAssistsCount(25);
        addFootballerDto.setMatchesCount(25);

        mockMvc.perform(post("/footballers/add-footballer")
                        .param("footballer", String.valueOf(addFootballerDto))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

    @Test
    void testViewDeleteFootballer() throws Exception {
        mockMvc.perform(get("/footballers/delete-footballer"))
                .andDo(print())
                .andExpect(view().name("delete-footballer"));
    }

    @Test
    void testDeleteFootballer() throws Exception {
        mockMvc.perform(delete("/footballers/delete-footballer/{name}","aaa")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

}
