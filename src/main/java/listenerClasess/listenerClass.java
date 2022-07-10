package listenerClasess;

import org.testng.ITestListener;
import org.testng.ITestResult;

import Utilclasses.ScreenRecorderUtil;

public class listenerClass  implements ITestListener {
	
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + "Test started");
	}
	
	public void    onTestSuccess(ITestResult result) {
		System.out.println(result.getName() + "Test passed");
	}
	
	public void onTestFail(ITestResult result) {
		System.out.println(result.getName() + "Test failed");
	}
	
	public void onTestskipped(ITestResult result) {
		System.out.println(result.getName() + "Test skipped");
	}
	
}
