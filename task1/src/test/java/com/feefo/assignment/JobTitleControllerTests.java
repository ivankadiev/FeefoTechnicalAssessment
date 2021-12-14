package com.feefo.assignment;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feefo.assignment.services.JobTitleService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
final class JobTitleControllerTests {
	private static final MediaType JSON_UTF8 = new MediaType("application", "json", UTF_8);
	private static final String JOB_TITLE = "JOB_TITLE";
	private static final List<String> JOB_TITLE_LIST = List.of(JOB_TITLE);
	private static String JOB_TITLE_LIST_JSON;
	private static final String NORMALIZED_JOB_TITLE = "NORMALIZED_JOB_TITLE";
	private static final List<String> NORMALIZED_JOB_TITLE_LIST = List.of(NORMALIZED_JOB_TITLE);
	private static String NORMALIZED_JOB_TITLE_LIST_JSON;

	@MockBean
	private JobTitleService service;

	@Autowired
	private MockMvc test;

	@BeforeAll
	static void initialize() throws JsonProcessingException {
		final var mapper = new ObjectMapper();
		JOB_TITLE_LIST_JSON = mapper.writeValueAsString(JOB_TITLE_LIST);
		NORMALIZED_JOB_TITLE_LIST_JSON = mapper.writeValueAsString(NORMALIZED_JOB_TITLE_LIST);
	}

	@Test
	@DisplayName("Get Normalized Job Title: 200")
	void getNormalizedJobTitle_200() throws Exception {
		// given
		final var request = post("/job-titles/get-normalized")
			.content(JOB_TITLE)
			.accept(JSON_UTF8);

		when(service
			.getNormalized(JOB_TITLE))
			.thenReturn(NORMALIZED_JOB_TITLE);

		// when
		final var result = test.perform(request);

		// then
		result.andExpect(status().isOk())
			.andExpect(response ->
				assertThat(response.getResponse().getContentAsString()).isEqualToIgnoringWhitespace(NORMALIZED_JOB_TITLE));

		verify(service).getNormalized(JOB_TITLE);
	}

	@Test
	@DisplayName("Get Normalized Job Title - Without Title: 200")
	void getNormalizedJobTitle_WithoutTitle_400() throws Exception {
		// given
		final var request = post("/job-titles/get-normalized")
			.accept(JSON_UTF8);

		// when
		final var result = test.perform(request);

		// then
		result.andExpect(status().isBadRequest())
			.andExpect(response ->
				assertThat(response.getResponse().getContentAsString()).isEmpty());
	}

	@Test
	@DisplayName("Get Normalized Job Titles: 200")
	void getNormalizedJobTitles_200() throws Exception {
		// given
		final var request = post("/job-titles/get-multiple-normalized")
			.content(JOB_TITLE_LIST_JSON)
			.contentType(JSON_UTF8)
			.accept(JSON_UTF8);

		when(service
			.getNormalized(JOB_TITLE_LIST))
			.thenReturn(NORMALIZED_JOB_TITLE_LIST);

		// when
		final var result = test.perform(request);

		// then
		result.andExpect(status().isOk())
			.andExpect(response -> assertThat(response.getResponse().getContentAsString())
				.isEqualToIgnoringWhitespace(NORMALIZED_JOB_TITLE_LIST_JSON));

		verify(service).getNormalized(JOB_TITLE_LIST);
	}

	@Test
	@DisplayName("Get Normalized Job Titles - Without Titles: 200")
	void getNormalizedJobTitles_WithoutTitles_400() throws Exception {
		// given
		final var request = post("/job-titles/get-multiple-normalized")
			.accept(JSON_UTF8);

		// when
		final var result = test.perform(request);

		// then
		result.andExpect(status().isBadRequest())
			.andExpect(response ->
				assertThat(response.getResponse().getContentAsString()).isEmpty());
	}
}
