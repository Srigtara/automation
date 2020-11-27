package utils;

/*
 * This class contains constants which are used across the application
 */
public interface Constants {

	public int SUCCESS_CODE = 200;
	public int SERVER_ERROR_CODE = 500;
	public int VALID_POST_REQUEST_CODE = 201;
	public int VALID_DELETE_REQUEST_CODE = 200;
	public int ERROR_CODE_NOT_FOUND = 404;
	public int ERROR_FORBIDEN = 404;
	public int TIMEOUT = 5000;
	public String PATH_TO_CONFIG_FILE = "/src/main/resources/config.properties";
	public String PATH_TO_TEST_DATA_FILE = "/src/main/resources/testData.properties";
	public String CONTENT_TYPE = "application/json; charset=utf-8";
	public String BASE_URL = "https://api.nasa.gov/planetary/apod";
	public String CURRENT_DIRNAME = "Current test results";
	public String ARCHIVED_DIRNAME = "Archived test results";
	public String TEST_RESULTS = "Test_Results";
	public String fileSeperator = System.getProperty("file.separator");
	public String sourceFilepath = System.getProperty("user.dir") + fileSeperator + CURRENT_DIRNAME;
	public String destinationFilepath = System.getProperty("user.dir") + fileSeperator + ARCHIVED_DIRNAME;
	public String REPORT_FILENAME = "Test-Automation-Report.html";

}
