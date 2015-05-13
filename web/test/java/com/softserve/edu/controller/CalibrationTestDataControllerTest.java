package com.softserve.edu.controller;

import com.softserve.edu.entity.CalibrationTest;
import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.service.CalibrationTestDataService;
import com.softserve.edu.service.CalibrationTestService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasItem;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CalibrationTestDataControllerTest {
    @InjectMocks
    private CalibrationTestDataController controller;

    @Mock
    private CalibrationTestDataService service;

    private MockMvc mockMvc;
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    public void getExistingTestData() throws Exception {
        CalibrationTestData testData = new CalibrationTestData();
        testData.setId(1L);
        testData.setActualConsumption(66D);

        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setId(1L);

        testData.setCalibrationTest(calibrationTest);

        when(service.findTestData(1L)).thenReturn(testData);

        mockMvc.perform(get("/calibrationTestData/1"))
                .andExpect(jsonPath("$.actualConsumption", is(testData.getActualConsumption())))
                .andExpect(jsonPath("$.links[*].href",
                        hasItems(endsWith("/calibrationTests/1"), endsWith("/calibrationTestData/1"))))
                .andExpect(jsonPath("$.links[*].rel",
                        hasItems(is("self"), is("owner"))))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingTestData() throws Exception {
        when(service.findTestData(1L)).thenReturn(null);

        mockMvc.perform(get("/calibrationTestData/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteExistingTestData() throws Exception {
        CalibrationTestData deletedCalibrationTestData = new CalibrationTestData();
        deletedCalibrationTestData.setId(1L);
        deletedCalibrationTestData.setActualConsumption(11.5);

        when(service.deleteTestData(1L)).thenReturn(deletedCalibrationTestData);

        mockMvc.perform(delete("/calibrationTestData/1"))
                .andExpect(jsonPath("$.actualConsumption", is(deletedCalibrationTestData.getActualConsumption())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTestData/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNonExistingTestData() throws Exception {
        when(service.deleteTestData(1L)).thenReturn(null);

        mockMvc.perform(delete("/calibrationTestData/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateExistingTestData() throws Exception {
        CalibrationTestData updatedTestData = new CalibrationTestData();
        updatedTestData.setId(1L);
        updatedTestData.setActualConsumption(9.0);

        when(service.updateTestData(eq(1L), any(CalibrationTestData.class)))
                .thenReturn(updatedTestData);

        mockMvc.perform(put("/calibrationTestData/1")
                .content("{\"actualConsumption\": 15.6 }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actualConsumption", is(updatedTestData.getActualConsumption())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTestData/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNonExistingTestData() throws Exception {
        when(service.updateTestData(eq(1L), any(CalibrationTestData.class)))
                .thenReturn(null);

        mockMvc.perform(put("/calibrationTestData/1")
                .content("{\"actualConsumption\": 55.6}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}