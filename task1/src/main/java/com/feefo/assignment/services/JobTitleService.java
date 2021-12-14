package com.feefo.assignment.services;

import java.util.List;

public interface JobTitleService {
	List<String> getNormalized(List<String> inputTitles);

	String getNormalized(String inputTitle);
}
