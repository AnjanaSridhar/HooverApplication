package com.hoover.backend;

import com.hoover.backend.controller.HooverController;
import com.hoover.backend.model.CoOrds;
import com.hoover.backend.model.Hoover;
import com.hoover.backend.service.HooverService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HooverController.class)
@AutoConfigureMockMvc
public class HooverControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private HooverService hooverService;

    private String json = "{\n" +
            "  \"roomSize\" : [5, 5],\n" +
            "  \"coords\" : [1, 2],\n" +
            "  \"patches\" : [\n" +
            "    [1, 0],\n" +
            "    [2, 2],\n" +
            "    [2, 3]\n" +
            "  ],\n" +
            "  \"instructions\" : \"EWNNESEESWNWW\"\n" +
            "}";



    @Test
    public void clean() throws Exception {
        BDDMockito.given(this.hooverService.startHoover(Mockito.any(), Mockito.any(),
                Mockito.any())).willReturn(new Hoover(new CoOrds(1, 2), 2));
        mockMvc.perform(post("/clean")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}

