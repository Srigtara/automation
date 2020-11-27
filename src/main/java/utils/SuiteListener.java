package utils;

import static utils.Constants.CURRENT_DIRNAME;
import static utils.Constants.TEST_RESULTS;
import static utils.Constants.destinationFilepath;
import static utils.Constants.fileSeperator;
import static utils.Constants.sourceFilepath;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*
 * This Class contains methods which run on suite level *
 */

public class SuiteListener implements ISuiteListener {

	static ExtentTest test;
	static ExtentReports report;

	/*
	 * This method sets the timeout values for the whole application across all test
	 * cases
	 */
	public void onStart(ISuite suite) {
		initOutputDirectories();
		report = new ExtentReports(System.getProperty("user.dir") + fileSeperator + CURRENT_DIRNAME + ".html", true);
		ExtentTestManager.startTest("API Test Automation");
	}

	public static void initOutputDirectories() {
		try {
			System.out.println("Initializing Directories...");
			File sourceDir = new File(sourceFilepath);
			File destinationDir = new File(destinationFilepath);
			if (!sourceDir.exists()) {
				sourceDir.mkdirs();
				return;
			}
			if (sourceDir.list().length > 0) {
				if (!destinationDir.exists()) {
					destinationDir.mkdirs();
				}
				FileUtils.moveDirectoryToDirectory(sourceDir, destinationDir, true);
				// Rename the file to contain current timestamp
				String newName = destinationFilepath + fileSeperator + TEST_RESULTS + "_" + System.currentTimeMillis();
				String oldName = destinationFilepath + fileSeperator + CURRENT_DIRNAME;
				File newFile = new File(newName);
				File oldFile = new File(oldName);
				oldFile.renameTo(newFile);
				sourceDir.mkdirs();
			}
		} catch (Exception e) {
			System.out.println("An exception occurred while moving directory" + e.getCause());
		}

	}

	/*
	 * 
	 * This method will run on finish of the test suite and quit the driver
	 * 
	 */
	public void onFinish(ISuite suite) {
		ExtentTestManager.extent.flush();
	}

}
