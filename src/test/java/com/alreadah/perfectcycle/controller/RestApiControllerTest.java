package com.alreadah.perfectcycle.controller;

import com.alraedah.perfectcycle.controller.RestApiController;
import com.alraedah.perfectcycle.model.FindPerfectCycleReq;
import com.alraedah.perfectcycle.service.PerfectCycleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.*;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RestApiControllerTest {
    @InjectMocks
    RestApiController restApiController;
    @Mock
    PerfectCycleService perfectCycleService;

    @BeforeEach
    public void setup(){
        perfectCycleService = mock(PerfectCycleService.class);
        restApiController = new RestApiController(perfectCycleService);
    }

    @Test
    void testFindPerfectCycleTrue(){
        List<FindPerfectCycleReq.Input> inputSet = new ArrayList<>();
        inputSet.add(FindPerfectCycleReq.Input.builder()
                .listName("list1")
                .listData(Arrays.asList(3,0,1,2))
                .build());
        when(perfectCycleService.findCycles(anyList())).thenReturn(true);
        List<String> result = restApiController.findPerfectCycle(FindPerfectCycleReq.builder().inputSet(inputSet).build());
        Assertions.assertEquals(" true", result.get(0).split(":")[2]);
    }

    @Test
    void testFindPerfectCycleFalse(){
        List<FindPerfectCycleReq.Input> inputSet = new ArrayList<>();
        inputSet.add(FindPerfectCycleReq.Input.builder()
                .listName("list1")
                .listData(Arrays.asList(2,0,1,2))
                .build());
        when(perfectCycleService.findCycles(anyList())).thenReturn(false);
        List<String> result = restApiController.findPerfectCycle(FindPerfectCycleReq.builder().inputSet(inputSet).build());
        Assertions.assertEquals(" false", result.get(0).split(":")[2]);
    }
}
