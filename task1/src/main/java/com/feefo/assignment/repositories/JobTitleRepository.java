package com.feefo.assignment.repositories;

import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class JobTitleRepository {
	public Set<String> getAll() {
		return Set.of("Architect", "Software engineer", "Quantity surveyor", "Accountant");
	}
}
