package com.feefo.assignment.views;

import lombok.Builder;
import lombok.Getter;
import lombok.With;

@Builder(toBuilder = true)
@Getter
@With
public class ScoredTitleView {
	private final String normalizedTitle;
	private final double score;
}
