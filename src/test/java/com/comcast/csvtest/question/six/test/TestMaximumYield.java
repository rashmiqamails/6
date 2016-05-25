package com.comcast.csvtest.question.six.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.csvtest.question.six.MaximumYield;

public class TestMaximumYield {
	
	static final Logger logger = LogManager.getLogger(TestMaximumYield.class); 

	private MaximumYield maximumYield = null;
	
	@BeforeSuite
	public void setup() {
		logger.debug("Initializing MaximumYield object to be tested");
		this.maximumYield = new MaximumYield();
	}
	
	@Test(dataProvider = "testDataProvider")
	public void test(int[] squares, int expectedUnits) {
		logger.info("Executing findMaximumYield with input {} and expected output is {}", squares, expectedUnits);
		int actualUnits = maximumYield.findMaximumYield(squares);
		Assert.assertEquals(actualUnits, expectedUnits);
	}
	
	@DataProvider(name = "testDataProvider")
	public Object[][] createTestDataProvider() {
		return new Object[][]{
			{new int[]{206}, 206},
			{new int[]{206, 506}, 506},
			{new int[]{306, 506, 10}, 506},
			{new int[]{206, 140, 300, 52, 107}, 613},
			{new int[]{147, 206, 52, 240, 300}, 506}
		};
	}
	
}
