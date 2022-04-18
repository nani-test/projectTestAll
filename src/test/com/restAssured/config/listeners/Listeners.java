package restAssured.config.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import restAssured.config.model.BaseTest;

public class Listeners extends BaseTest implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
// TODO Auto-generated method stub
    }

    @Override
    public void onTestSuccess(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Success of test cases and its details are : "+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+ result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Skip of test cases and its details are : "+ result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
// TODO Auto-generated method stub
        System.out.println("Failure of test cases and its details are : "+ result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Starting execution = " +  context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
// TODO Auto-generated method stub
    }
}
