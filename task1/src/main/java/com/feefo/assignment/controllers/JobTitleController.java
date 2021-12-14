package com.feefo.assignment.controllers;

import java.util.List;

import javax.validation.constraints.NotNull;

import com.feefo.assignment.services.JobTitleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/job-titles")
public class JobTitleController {
	@Autowired
	private JobTitleService service;

	@PostMapping("/get-normalized")
	public final ResponseEntity<String> getNormalizedJobTitle(@RequestBody @NotNull final String title) {
		return status(OK).body(service.getNormalized(title));
	}

	@PostMapping("/get-multiple-normalized")
	public final ResponseEntity<List<String>> getNormalizedJobTitles(@RequestBody @NotNull final List<String> titles) {
		return status(OK).body(service.getNormalized(titles));
	}
}
