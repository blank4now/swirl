package ca.droppings.swirl.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class SwirlListener extends RunListener {
	public void testRunStarted(Description description) throws java.lang.Exception {
		if (description.isSuite()) {
			spew("TestSuite: " + description.getClassName());
		} else if (description.isTest()) {
			spew("Test     : " + description.getClassName());
		}	else {
			spew("No tests : " + description.getClassName());
			
		}
		spew(description.getClass() + " Number of TestCases to execute:" + description.testCount());
	}
	public void testRunFinished(Result result) throws java.lang.Exception {
		spew(" Number of TestCases executed,ignored and failed: " + result.getRunCount() + " " + result.getIgnoreCount() + " " + result.getFailureCount());
	}
	public void testStarted(Description description) {
		spew(description.getClassName() + " " + description.getMethodName() + " starting");
	}
	public void testFinished(Description description) {
		spew(description.getClassName() + " " + description.getMethodName() + " finished");
	}
	public void testIgnored(Description description) throws java.lang.Exception {
		spew(description.getClassName() + " " + description.getMethodName() + " ignored");
	}
	public void testFailure(Failure failure) throws java.lang.Exception {
		spew(failure.getClass() + " failed " + failure.getMessage());
	}
	private void spew(String whatever) {
		LocalDateTime localDateTimeStamp = LocalDateTime.now();
		String isoDateTime = localDateTimeStamp.format(DateTimeFormatter.ISO_DATE_TIME);
		System.out.println(isoDateTime + " " + whatever);
	}

}
