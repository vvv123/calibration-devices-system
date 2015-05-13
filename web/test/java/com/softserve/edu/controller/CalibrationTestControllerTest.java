package com.softserve.edu.controller;

import com.softserve.edu.entity.CalibrationTestData;
import com.softserve.edu.service.CalibrationTestService;
import com.softserve.edu.service.exceptions.CalibrationTestNotFoundException;
import com.softserve.edu.service.utils.CalibrationTestDataList;
import com.softserve.edu.service.utils.CalibrationTestList;
import org.mockito.InjectMocks;
import com.softserve.edu.entity.CalibrationTest;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void getExistingCalibrationTest() throws Exception {
        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setId(1L);
        calibrationTest.setName("test Name");

        when(service.findTest(calibrationTest.getId())).thenReturn(calibrationTest);
        mockMvc.perform(get("/calibrationTests/" + calibrationTest.getId()))
                .andExpect(jsonPath("$.name", is(calibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTests/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void getNonExistingCalibrationTest() throws Exception {
        when(service.findTest(1L)).thenReturn(null);

        mockMvc.perform(get("/calibrationTests/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void deleteExistingCalibrationTest() throws Exception {
        CalibrationTest deletedCalibrationTest = new CalibrationTest();
        deletedCalibrationTest.setId(1L);
        deletedCalibrationTest.setName("Test Title");

        when(service.deleteTest(1L)).thenReturn(deletedCalibrationTest);

        mockMvc.perform(delete("/calibrationTests/1"))
                .andExpect(jsonPath("$.name", is(deletedCalibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTests/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void deleteNonExistingCalibrationTest() throws Exception {
        when(service.deleteTest(1L)).thenReturn(null);

        mockMvc.perform(delete("/calibrationTests/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateExistingCalibrationTest() throws Exception {
        CalibrationTest updatedCalibrationTest = new CalibrationTest();
        updatedCalibrationTest.setId(1L);
        updatedCalibrationTest.setName("Test Title155");

        when(service.updateTest(eq(1L), any(CalibrationTest.class)))
                .thenReturn(updatedCalibrationTest);

        mockMvc.perform(put("/calibrationTests/1")
                .content("{\"name\":\"Test Title666\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name", is(updatedCalibrationTest.getName())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTests/1"))))
                .andExpect(status().isOk());
    }

    @Test
    public void updateNonExistingCalibrationTest() throws Exception {
        when(service.updateTest(eq(1L), any(CalibrationTest.class)))
                .thenReturn(null);

        mockMvc.perform(put("/calibrationTests/1")
                .content("{\"name\":\"Test Title666\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void createCalibrationTest() throws Exception{
        CalibrationTest createdCalibrationTest = new CalibrationTest();
        createdCalibrationTest.setId(1L);
        createdCalibrationTest.setName("Test A");

        when(service.createTest(any(CalibrationTest.class))).thenReturn(createdCalibrationTest);

        mockMvc.perform(post("/calibrationTests")
                .content("{\"name\":\"Test A\"}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("Location", endsWith("calibrationTests/1")))
                .andExpect(jsonPath("$.name", is(createdCalibrationTest.getName())))
                .andExpect(status().isCreated());
    }

    @Test
    public void findAllCalibrationTests() throws Exception {
        List<CalibrationTest> calibrationTests = new ArrayList<>();

        CalibrationTest calibrationTest1 = new CalibrationTest();
        calibrationTest1.setId(1L);
        calibrationTest1.setName("calibrationTest1");
        calibrationTests.add(calibrationTest1);

        CalibrationTest calibrationTest2 = new CalibrationTest();
        calibrationTest2.setId(1L);
        calibrationTest2.setName("calibrationTest2");
        calibrationTests.add(calibrationTest2);

        CalibrationTestList calibrationTestList = new CalibrationTestList(calibrationTests);

        when(service.findAllCalibrationTests()).thenReturn(calibrationTestList);

        mockMvc.perform(get("/calibrationTests"))
                .andExpect(jsonPath("$.calibrationTests[*].name",
                        hasItems(endsWith("calibrationTest1"), endsWith("calibrationTest2"))))
                .andExpect(status().isOk());
    }

    @Test
    public void createTestDataForExistingCalibrationTest() throws Exception {
        CalibrationTest calibrationTest = new CalibrationTest();
        calibrationTest.setId(1L);

        CalibrationTestData testData = new CalibrationTestData();
        testData.setActualConsumption(55D);
        testData.setId(1L);

        when(service.createTestData(eq(1L), any(CalibrationTestData.class))).thenReturn(testData);

        mockMvc.perform(post("/calibrationTests/1/testData")
                .content("{\"actualConsumption\": 55.0 }")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.actualConsumption", is(testData.getActualConsumption())))
                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("calibrationTestData/1"))))
                .andExpect(header().string("Location", endsWith("calibrationTestData/1")))
                .andExpect(status().isCreated());
    }

    @Test
    public void createTestDataForNonExistingCalibrationTest() throws Exception{
        when(service.createTestData(eq(1L), any(CalibrationTestData.class))).thenThrow(new CalibrationTestNotFoundException());

        mockMvc.perform(post("/calibrationTests/1/testData")
                .content("{\"actualConsumption\": 33.0}")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    public void  listCalibrationTestDataForExistingTest() throws Exception {

        CalibrationTestData testData1 = new CalibrationTestData();
        testData1.setId(1L);
        testData1.setActualConsumption(55.2);

        CalibrationTestData testData2 = new CalibrationTestData();
        testData2.setId(2L);
        testData2.setActualConsumption(32.2);

        List<CalibrationTestData> testDataList = new ArrayList();
        testDataList.add(testData1);
        testDataList.add(testData2);

        CalibrationTestDataList list = new CalibrationTestDataList(1L, testDataList);

        when(service.findAllTestDataAsociatedWithTest(1L)).thenReturn(list);

        mockMvc.perform(get("/calibrationTests/1/testData"))

                .andExpect(jsonPath("$.links[*].href", hasItem(endsWith("/calibrationTests/1/testData"))))
                .andExpect(status().isOk());
    }

    @Test
    public void  listCalibrationTestDataForNonExistingTest() throws Exception {
        when(service.findAllTestDataAsociatedWithTest(1L))
                .thenThrow(new CalibrationTestNotFoundException());

        mockMvc.perform(get("/calibrationTests/1/testData"))
                .andExpect(status().isNotFound());
    }
}