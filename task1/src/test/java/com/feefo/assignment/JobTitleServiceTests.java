package com.feefo.assignment;

import java.util.List;

import com.feefo.assignment.repositories.JobTitleRepository;
import com.feefo.assignment.services.JobTitleServiceImpl;

import org.apache.commons.text.similarity.JaroWinklerDistance;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
final class JobTitleServiceTests {
	private static final String ACCOUNTANT = "Accountant";
	private static final String C_SHARP_ENGINEER = "C# engineer";
	private static final String CHIEF_ACCOUNTANT = "Chief Accountant";
	private static final String JAVA_ENGINEER = "Java engineer";
	private static final String SOFTWARE_ENGINEER = "Software engineer";
	private static final int ALL_TITLES_COUNT = 4;

	@Spy
	private JaroWinklerDistance matcher;

	@Spy
	private JobTitleRepository repository;

	@InjectMocks
	private JobTitleServiceImpl test;

	@Test
	@DisplayName("Get Normalized - With Java Engineer: Success - Software Engineer")
	void getNormalized_WithJavaEngineer_Success() {
		// given / when
		final var result = test.getNormalized(JAVA_ENGINEER);

		// then
		assertEquals(SOFTWARE_ENGINEER, result);
		verify(repository).getAll();
		verify(matcher, times(ALL_TITLES_COUNT)).apply(eq(JAVA_ENGINEER), anyString());
	}

	@Test
	@DisplayName("Get Normalized - With C# Engineer: Success - Software Engineer")
	void getNormalized_WithCSharpEngineer_Success() {
		// given / when
		final var result = test.getNormalized(C_SHARP_ENGINEER);

		// then
		assertEquals(SOFTWARE_ENGINEER, result);
		verify(repository).getAll();
		verify(matcher, times(ALL_TITLES_COUNT)).apply(eq(C_SHARP_ENGINEER), anyString());
	}

	@Test
	@DisplayName("Get Normalized - With Accountant: Success - Accountant")
	void getNormalized_WithAccountant_Success() {
		// given / when
		final var result = test.getNormalized(ACCOUNTANT);

		// then
		assertEquals(ACCOUNTANT, result);
		verify(repository).getAll();
		verify(matcher, times(ALL_TITLES_COUNT)).apply(eq(ACCOUNTANT), anyString());
	}

	@Test
	@DisplayName("Get Normalized - With Chief Accountant: Success - Accountant")
	void getNormalized_WithChiefAccountant_Success() {
		// given / when
		final var result = test.getNormalized(CHIEF_ACCOUNTANT);

		// then
		assertEquals(ACCOUNTANT, result);
		verify(repository).getAll();
		verify(matcher, times(ALL_TITLES_COUNT)).apply(eq(CHIEF_ACCOUNTANT), anyString());
	}

	@Test
	@DisplayName("Get Normalized - With List Parameter: Success")
	void getNormalized_WithList_Success() {
		// given / when
		final var result = test.getNormalized(List.of(JAVA_ENGINEER));

		// then
		assertEquals(List.of(SOFTWARE_ENGINEER), result);
		verify(repository).getAll();
		verify(matcher, times(ALL_TITLES_COUNT)).apply(eq(JAVA_ENGINEER), anyString());
	}
}
