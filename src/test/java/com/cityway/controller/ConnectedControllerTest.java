package com.cityway.controller;

import com.cityway.service.ConnectedService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ConnectedController.class)
public class ConnectedControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ConnectedService connectedService;

    @Test
    public void isConnectedRequest() throws Exception {
        String origin = "Trenton";
        String destination = "Albany";
        when(connectedService.isConnected(origin,destination)).thenReturn(true);
        this.mockMvc.perform(get("/connected?origin="+origin+"&destination=" + destination))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string("yes"));
    }

    @Test
    public void isConnectedRequestEmptyException() throws Exception {
        String origin = "";
        String destination = "";
        this.mockMvc.perform(get("/connected?origin="+origin+"&destination=" + destination))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"code\":500,\"message\":\"origin or destination parameter cannot have a empty value\"}"));
    }
}