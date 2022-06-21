package com.java.testNG.Initiliazer;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(MyOwnListernersTest.class)
public class ListenerTest {

	@BeforeTest
	public void launch() {
		System.out.println("Chrome Launching");
	}

	@Test
	public void test11() {
		System.out.println("Testing is Started");
	}

	@AfterTest
	public void test1() {
		System.out.println("Testing is Completed");
	}
}
