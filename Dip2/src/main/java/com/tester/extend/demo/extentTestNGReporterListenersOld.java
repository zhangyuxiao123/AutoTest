package com.tester.extend.demo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.ResourceCDN;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import org.testng.*;
import org.testng.xml.XmlSuite;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

 public class extentTestNGReporterListenersOld implements IReporter {

    private static final String OUTPUT_FOLDER = "test-output/";
    private static final String FILE_NAME = "Extent.html";

    private ExtentReports extent;

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
        init();

        for (ISuite suite : suites) {
            Map<String,ISuiteResult> result = suite.getResults();

            for (ISuiteResult r : result.values()) {
                ITestContext context = r.getTestContext();

                buildTestNodes(context.getFailedTests(), Status.FAIL);
                buildTestNodes(context.getSkippedTests(), Status.SKIP);
                buildTestNodes(context.getPassedTests(), Status.PASS);

            }
        }

        for (String s : Reporter.getOutput()) {
            extent.setTestRunnerOutput(s);
        }

        extent.flush();
    }

    private void init() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(OUTPUT_FOLDER + FILE_NAME);
        //设置静态文件的NDS
        //怎么样解决cdn.rawgit.com访问不了的情况
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        htmlReporter.config().setDocumentTitle("自动化测试报告");
        htmlReporter.config().setReportName("API自动化测试报告");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //图表位置
        //htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setResourceCDN(ResourceCDN.EXTENTREPORTS);
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setReportUsesManualConfiguration(true);
    }

    private void buildTestNodes(IResultMap tests, Status status) {
        ExtentTest test;

        if (tests.size() > 0) {
            for (ITestResult result : tests.getAllResults()) {
                test = extent.createTest(result.getMethod().getMethodName()); //显示方法名称
                //test.createNode("子案例");  //创建子案例

                for (String group : result.getMethod().getGroups())
                    test.assignCategory(group); //根据group

                if (result.getThrowable() != null) {
                    test.log(status, result.getThrowable()); //异常案例，显示log到报告
                }
                else {
                    test.log(status, "Test " + status.toString().toLowerCase() + "ed");
                }

                test.getModel().setStartTime(getTime(result.getStartMillis()));
                test.getModel().setEndTime(getTime(result.getEndMillis()));
                test.getModel().setDescription("测试案例执行！");
            }
        }
    }

    private Date getTime(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar.getTime();
    }
}
