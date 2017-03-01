package test.algorithms.search;

import org.junit.Before;
import org.junit.Test;

import algorithms.search.LinearSearch;

import static org.assertj.core.api.Assertions.*;

public class LinearSearchTest {
	
	private LinearSearch testLinearSearch;
	
	@Before
	public void beforeSetup() {
		testLinearSearch = new LinearSearch();
	}
	
	@Test
	public void testLinearSearchSuccess() {
		int[] arrayOfIntegers = {5,1,4,3,2,7,8,4};
		int value = 4;
		String answer = testLinearSearch.linearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item found @ index 7");
	}
	
	@Test
	public void testLinearFail() {
		int[] arrayOfIntegers = {5,1,4,3,2,7,8,4};
		int value = 10;
		String answer = testLinearSearch.linearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item not found");
	}
		
	@Test
	public void testBetterLinearSearchSuccess() {
		int[] arrayOfIntegers = {5,1,4,3,2,7,8,4};
		int value = 4;
		String answer = testLinearSearch.betterLinearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item found @ index 2");
	}
	
	@Test
	public void testBetterLinearSearchFail() {
		int[] arrayOfIntegers = {5,1,4,3,2,7,8,4};
		int value = 6;
		String answer = testLinearSearch.betterLinearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item not found");
	}
	
	@Test
	public void testSentinelLinearSearchSuccess() {
		int[] arrayOfIntegers = {5,1,4,12,2,7,8};
		int value = 12;
		String answer = testLinearSearch.sentinelLinearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item found @ index 3");
	}
	
	@Test
	public void testSentinelLinearSearchFail() {
		int[] arrayOfIntegers = {5,1,4,3,2,7,8};
		int value = 9;
		String answer = testLinearSearch.sentinelLinearSearch(arrayOfIntegers, value);
		assertThat(answer).isEqualTo("Item not found");
	}

}
