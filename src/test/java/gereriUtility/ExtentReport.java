package gereriUtility;


	import com.aventstack.extentreports.ExtentReports;
	import com.aventstack.extentreports.reporter.ExtentSparkReporter;

	public class ExtentReport {

	    public static ExtentReports getReport() {

	        ExtentSparkReporter spark =
	                new ExtentSparkReporter("./ExtentReports/ExtentReport.html");

	        spark.config().setReportName("Cabcher Automation Report");
	        spark.config().setDocumentTitle("Automation Test Results");

	        ExtentReports report = new ExtentReports();
	        report.attachReporter(spark);

	        report.setSystemInfo("OS", "Windows");
	        report.setSystemInfo("Browser", "Chrome");
	        report.setSystemInfo("Tester", "Automation Team");

	        return report;
	    }
	}


