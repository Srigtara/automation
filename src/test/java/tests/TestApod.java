package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import rest_assured.HttpClientHandler;
import utils.CommonUtilities;
import utils.Constants;
import utils.ReadPropertyFile;

public class TestApod {

	ReadPropertyFile properties;
	Response response;
	public int statusCode;
	ObjectMapper mapper;
	JsonNode presentJson;

	@BeforeTest(groups = { "smoke", "functionalTest" })
	public void setUp() {
		CommonUtilities.startExtentReport();
		properties = new ReadPropertyFile();
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_200_Valid_Response() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "DATE", "HD1", "CONCEPT_TAG1"));
		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation Failed");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_403_InCase_of_Invalid_API_Key() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("INVALID_API_KEY", "DATE", "HD1", "CONCEPT_TAG1"));
		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.ERROR_FORBIDEN, "403 not returned");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_400_InCase_of_Future_Date() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "FUTURE_DATE", "HD1", "CONCEPT_TAG1"));
		Assert.assertEquals(response.getStatusCode(), Constants.ERROR_BADREQUEST, "status code validation Failed");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_400_InCase_of_Past_Date() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "PAST_DATE", "HD1", "CONCEPT_TAG1"));
		Assert.assertEquals(response.getStatusCode(), Constants.ERROR_BADREQUEST, "status code validation Failed");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_InCase_of_HD_False() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "DATE", "HD2", "CONCEPT_TAG1"));
		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation Failed");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_Is_returning_200_InCase_of_Concept_tag_False() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "DATE", "HD1", "CONCEPT_TAG2"));
		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation Failed");
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_InCase_of_HD_Concept_Tag_False() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("API_KEY", "DATE", "HD2", "CONCEPT_TAG2"));
		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation Failed");
	}

	@Test(groups = { "smoke	" })
	public void validate_APOD_API_is_Returning_403_With_EMPTYFIELDS() {
		response = HttpClientHandler.requestGetCall("",
				CommonUtilities.getQueryParams("NULL_API_KEY", "NULL_DATE", "NULL_HD", "NULL_CONCEPT_TAG"));
		// statusCode = response.getStatusCode();
		Assert.assertEquals(response.getStatusCode(), Constants.ERROR_FORBIDEN, "403 not returned");
	}

	@AfterTest(groups = { "smoke", "functionalTest" })
	public void tearDown() {
		CommonUtilities.endReport();
	}

}