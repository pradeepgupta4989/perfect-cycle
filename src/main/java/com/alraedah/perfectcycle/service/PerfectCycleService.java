package com.alraedah.perfectcycle.service;

import com.alraedah.perfectcycle.model.Node;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PerfectCycleService {
    boolean isPrefectCycle;
    private static final int startIndex = 0;

    public boolean findCycles(List<Integer> input) {
        log.info("Input request : " + input);
        if (!CollectionUtils.isEmpty(input)) {
            int size = input.size();
            //prepare node data with index and index value
            List<Node> nodes = new ArrayList<>(size);
            List<Boolean> visited = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                nodes.add(Node.builder().index(i).value(input.get(i)).build());
                visited.add(false);
            }
            findCyclesUtil(nodes, startIndex, visited);
        }
        log.info("Given Array : {} , Perfect cycle exist : {}", input, isPrefectCycle);
        return isPrefectCycle;
    }

    private void findCyclesUtil(List<Node> pairs, int start, List<Boolean> visited) {
        visited.set(start, true);
        int next = pairs.get(start).getValue();
        if (next < visited.size() && !visited.get(next)) {
            findCyclesUtil(pairs, next, visited);
        } else {
            isPrefectCycle = !visited.contains(false) && next == startIndex;
            log.info("Is prefect Cycle : {}", isPrefectCycle);
        }
    }
}
