package com.TestRunner;

import org.testng.annotations.Test;

public class TestTest {
	@Test(priority = 1)
	private void first() {
		System.out.println("1");

	}
	@Test(priority = 2)
	private void second() {
		System.out.println("2");	

	}
	@Test(priority = 3)
	private void thired() {
		System.out.println("3");

	}
	@Test()
	private void fourth() {
		

	}
	@Test(dependsOnMethods = "fourth")
	private void fifth() {
		

	}
	@Test(dependsOnMethods = "fifth")
	private void sixth() {
		

	}

}
