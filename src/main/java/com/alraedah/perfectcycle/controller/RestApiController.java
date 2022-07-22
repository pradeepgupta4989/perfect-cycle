package com.alraedah.perfectcycle.controller;

import com.alraedah.perfectcycle.model.FindPerfectCycleReq;
import com.alraedah.perfectcycle.service.PerfectCycleService;
import lombok.AllArgsConstructor;

import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class RestApiController {

	private final PerfectCycleService perfectCycleService;

	@PostMapping("/perfect-cycle")
	public List<String> findPerfectCycle(@RequestBody FindPerfectCycleReq perfectCycleReq) {
		List<String> resultList = new ArrayList<>();
		if(null != perfectCycleReq && !CollectionUtils.isEmpty(perfectCycleReq.getInputSet())){
			perfectCycleReq.getInputSet().forEach(input ->
							resultList.add(input.getListName() +" : perfect cycle : "
									+ perfectCycleService.findCycles(input.getListData())));
		}
		return resultList;
	}
}