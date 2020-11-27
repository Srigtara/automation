package utils;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

/*
 * This class contains common utilities which are used across the application
 */
public class CommonUtilities {

	static ExtentTest test;
	static ExtentReports report;
	String currentTime;
	public static final String currentTimestamp = getCurrentTimestamp();

	/*
	 * This method starts the extent report
	 * 
	 */
	public static void startExtentReport() {
		if (report == null || test == null) {
			report = new ExtentReports(System.getProperty("user.dir")
					+ "\\Current test results\\ApiAutomationSuiteResults" + CommonUtilities.currentTimestamp + ".html");
			test = report.startTest("Api_Automation_Testing");

		}

	}

	/*
	 * This method ends the extent report
	 * 
	 */

	public static void endReport() {
		report.endTest(test);
		report.flush();
	}

	/*
	 * This method returns the current timestamp
	 * 
	 */
	public static String getCurrentTimestamp() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		Date date = new Date();
		return dateFormat.format(date);

	}

	/*
	 * 
	 * This method checks if a folder exist on a specific location or not
	 */
	public static boolean checkFolderExistsAtLocation(String filePath) {

		File f = new File(filePath);
		if (f.exists() && f.isDirectory()) {
			return true;
		}
		return false;
	}

	/*
	 * 
	 * This method move source directory to the destination
	 */
	public static void moveFileSrcToDest(String source, String destination) {

		try {
			File src = new File(source);
			File dest = new File(destination);

			FileUtils.copyDirectory(src, dest);

		} catch (Exception e) {
			e.getMessage();

		}

	}

	/*
	 * 
	 * This method deletes the file from the specific location
	 */
	public static void deleteFolderFromLocation(String location) {
		File f = new File(location);
		String[] entries = f.list();
		for (String s : entries) {
			File currentFile = new File(f.getPath(), s);
			currentFile.delete();
		}
		f.delete();
	}

	public static void flushMap(Map map) {
		map.clear();
	}

}
