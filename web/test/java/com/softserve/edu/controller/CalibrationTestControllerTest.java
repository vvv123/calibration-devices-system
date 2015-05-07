package com.softserve.edu.controller;

import com.softserve.edu.service.CalibrationTestService;
import org.mockito.InjectMocks;
import com.softserve.edu.entity.CalibrationTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


public class CalibrationTestControllerTest {
    @InjectMocks
    private CalibrationTestController controller;



    @Mock
    private CalibrationTestService service;


    private MockMvc mockMvc;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingCallibrationTest() throws Exception {
        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setId(1L);
        calibrationTest.setName("test Name");

        when(service.findTest(1L)).thenReturn(calibrationTest);
        mockMvc.perform(get("/calibrationTest/1"))
                .andDo(print())
                .andExpect(jsonPath("$.name", is(calibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTest/1"))))
                .andExpect(status().isOk());

    }

    @Test
    public void getNonExistingCalibrationTest() throws Exception {
        when(service.findTest(1L)).thenReturn(null);

        mockMvc.perform(get("/calibrationTest/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteExistingCalibrationTest() throws Exception {
        CalibrationTest deletedCalibrationTest = new CalibrationTest();
        deletedCalibrationTest.setId(1L);
        deletedCalibrationTest.setName("Test Title");

        when(service.deleteTest(1L)).thenReturn(deletedCalibrationTest);

        mockMvc.perform(delete("/calibrationTest/1"))
             //   .andDo(print())
                .andExpect(jsonPath("$.name", is(deletedCalibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTest/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNonExistingCalibationTest() throws Exception {
        when(service.deleteTest(1L)).thenReturn(null);

        mockMvc.perform(delete("/calibrationTest/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateExistinCalibrationTest() throws Exception {
        CalibrationTest updatedCalibrationTest = new CalibrationTest();
        updatedCalibrationTest.setId(1L);
        updatedCalibrationTest.setName("Test Title155");

        when(service.updateTest(eq(1L), any(CalibrationTest.class)))
                .thenReturn(updatedCalibrationTest);

        mockMvc.perform(put("/calibrationTest/1")
                .content("{\"name\":\"Test Title666\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(updatedCalibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTest/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNonExistingCalibrationTest() throws Exception {
        when(service.updateTest(eq(1L), any(CalibrationTest.class)))
                .thenReturn(null);

        mockMvc.perform(put("/calibrationTest/1")
                .content("{\"name\":\"Test Title666\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createCalibrationTest() throws Exception{

    }
}