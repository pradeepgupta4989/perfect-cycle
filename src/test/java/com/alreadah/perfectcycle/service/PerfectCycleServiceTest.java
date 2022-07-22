package com.alreadah.perfectcycle.service;

import com.alraedah.perfectcycle.service.PerfectCycleService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class PerfectCycleServiceTest {
    @InjectMocks
    PerfectCycleService perfectCycleService;

    @Test
    void testPerfectCycleTrueCase1(){
        List<Integer> inputData = Arrays.asList(3,0,1,2);
        boolean result = perfectCycleService.findCycles(inputData);
        Assertions.assertTrue(result);
    }

    @Test
    void testPerfectCycleTrueCase2(){
        List<Integer> inputData = Arrays.asList(2,0,1);
        boolean result = perfectCycleService.findCycles(inputData);
        Assertions.assertTrue(result);
    }

    @Test
    void testPerfectCycleFalseCase1(){
        List<Integer> inputData = Arrays.asList(1,2,3);
        boolean result = perfectCycleService.findCycles(inputData);
        Assertions.assertFalse(result);
    }

    @Test
    void testPerfectCycleFalseCase2(){
        List<Integer> inputData = Arrays.asList(0,2,5);
        boolean result = perfectCycleService.findCycles(inputData);
        Assertions.assertFalse(result);
    }
}
