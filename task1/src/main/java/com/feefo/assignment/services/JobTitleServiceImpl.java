package com.feefo.assignment.services;

import java.util.List;
import java.util.stream.Collectors;

import com.feefo.assignment.repositories.JobTitleRepository;
import com.feefo.assignment.views.ScoredTitleView;

import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobTitleServiceImpl implements JobTitleService {
	private static final ScoredTitleView EMPTY_SCORED_TITLE_VIEW = ScoredTitleView.builder()
		.normalizedTitle("")
		.build();

	@Autowired
	private JaroWinklerDistance matcher;

	@Autowired
	private JobTitleRepository repository;

	@Override
	public final List<String> getNormalized(final List<String> inputTitles) {
		return inputTitles.stream()
			.map(this::getNormalized)
			.collect(Collectors.toList());
	}

	@Override
	public final String getNormalized(final String inputTitle) {
		return repository.getAll()
			.stream()
			.map(title -> getScoredTitleView(inputTitle, title))
			.reduce(EMPTY_SCORED_TITLE_VIEW, this::compareScoredTitleViews)
			.getNormalizedTitle();
	}

	private ScoredTitleView getScoredTitleView(final String inputTitle, final String normalizedTitle) {
		return ScoredTitleView.builder()
			.normalizedTitle(normalizedTitle)
			.score(matcher.apply(inputTitle, normalizedTitle))
			.build();
	}

	private ScoredTitleView compareScoredTitleViews(final ScoredTitleView bestMatch, final ScoredTitleView next) {
		return bestMatch.getScore() > next.getScore()
			? bestMatch
			: next;
	}
}
