package org.football_project.controllers;

import org.football_project.dtos.AddFootballerDto;
import org.football_project.dtos.AddManagerDto;
import org.football_project.entities.enums.PositionEnum;
import org.football_project.entities.enums.TitleEnum;
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
public class ManagerControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testViewManagers() throws Exception {
        mockMvc.perform(get("/managers/view-managers"))
                .andDo(print())
                .andExpect(view().name("view-managers"));
    }

    @Test
    void testAddManager() throws Exception {
        mockMvc.perform(get("/managers/add-manager"))
                .andDo(print())
                .andExpect(view().name("add-manager"));
    }

    @Test
    void testDoAddManager() throws Exception {
        AddManagerDto addManagerDto = new AddManagerDto();
        addManagerDto.setName("manager");
        addManagerDto.setAge(25);
        addManagerDto.setTitle(TitleEnum.HEAD_COACH);

        mockMvc.perform(post("/managers/add-manager")
                        .param("manager", String.valueOf(addManagerDto))
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

    @Test
    void testViewDeleteManager() throws Exception {
        mockMvc.perform(get("/managers/delete-manager"))
                .andDo(print())
                .andExpect(view().name("delete-manager"));
    }

    @Test
    void testDeleteManager() throws Exception {
        mockMvc.perform(delete("/managers/delete-manager/{name}","aaa")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/club"));
    }

}
