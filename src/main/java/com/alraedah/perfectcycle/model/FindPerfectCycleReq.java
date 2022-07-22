package com.alraedah.perfectcycle.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class FindPerfectCycleReq {

    private List<Input> inputSet;

    @Data
    @Builder
    @AllArgsConstructor
    public static class Input {
        private String listName;
        private List<Integer> listData;
    }
}