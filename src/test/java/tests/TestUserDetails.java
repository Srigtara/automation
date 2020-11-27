package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import rest_assured.HttpClientHandler;
import utils.CommonUtilities;
import utils.Constants;
import utils.ReadPropertyFile;

public class TestUserDetails {

	public TestUserDetails() throws IOException {
		super();
	}

	ReadPropertyFile properties;
	RequestSpecification httpRequest;
	Response response;
	public int statusCode;
	public String json_Size;
	public String statusLine;
	public String contentType;
	public String id;
	public String title;
	public String body;
	ObjectMapper mapper;
	JsonNode presentJson;
	public String invalidUser;
	Map<String, String> map = new HashMap<String, String>();

	@BeforeTest(groups = { "smoke", "functionalTest" })
	public void setUp() {
		CommonUtilities.startExtentReport();
		properties = new ReadPropertyFile();
	}

	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_Valid_Response() {
		String params = "";
		Map<String,String> queryParamMap = new HashMap<String,String>();
		
		queryParamMap.put("api_key", "n6E8q0m73fn7ZFfVeiqiKbVwdhnHIOgxuqjeGRjU");
		queryParamMap.put("date", "2020-1-01");
		queryParamMap.put("hd", "true");
		queryParamMap.put("concept_tags", "true");
		
		response = HttpClientHandler.requestGetCall(params,queryParamMap);
		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.SUCCESS_CODE, "status code validation Failed");
	}
	
	@Test(groups = { "smoke" })
	public void validate_APOD_API_is_Returning_403_InCase_of_Invalid_API_Key() {
		String params = "";
		Map<String,String> queryParamMap = new HashMap<String,String>();
		
		queryParamMap.put("api_key", "n6E8q0m73fnfVeiqiKbVwdhnHIOgxuqjeGRjU");
		queryParamMap.put("date", "2020-1-01");
		queryParamMap.put("hd", "true");
		queryParamMap.put("concept_tags", "true");
		
		response = HttpClientHandler.requestGetCall(params,queryParamMap);
		statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, Constants.ERROR_FORBIDEN, "403 not returned");
	}

	@Test(groups = { "smoke" })
	public void validate_New_User_creation_Functionality_Is_Working_Fine() {
		map.put("userId", "2");
		map.put("id", "19");
		map.put("title", "this is projectdebug.com");
		map.put("body", "this is REST-Assured Tutorial");
		response = HttpClientHandler.requestPostCall(map);
		statusCode = response.getStatusCode();
		CommonUtilities.flushMap(map);
		Assert.assertEquals(statusCode, Constants.VALID_POST_REQUEST_CODE, "status code validation failed");
	}

	@Test(groups = { "smoke" })
	public void validate_Delete_User_Functionality_Is_Working_Fine() {
		response = HttpClientHandler.requestDeleteCall(properties.getProperty("VALID_ID"));
		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation failed");
	}

//	@Test(groups = { "smoke" })
//	public void validate_Status_Code_After_Updating_User_Details() throws FileNotFoundException {
//		map.put("userId", properties.getpropertieserty("VALID_USER_ID"));
//		map.put("id", properties.getpropertieserty("VALID_ID"));
//		map.put("title", properties.getpropertieserty("UPDATED_TITLE"));
//		map.put("body", properties.getpropertieserty("UPDATED_BODY"));
//		response = HttpClientHandler.requestPutCall(properties.getpropertieserty("VALID_ID"), map);
//		CommonUtilities.flushMap(map);
//		Assert.assertEquals(response.getStatusCode(), Constants.SUCCESS_CODE, "status code validation failed");
//
//	}
//
//	@Test(groups = { "functionalTest" })
//	public void validate_Id_Should_Not_Be_Updated() throws FileNotFoundException {
//		map.put("userId", properties.getpropertieserty("VALID_USER_ID"));
//		map.put("id", properties.getpropertieserty("UPDATED_ID"));
//		map.put("title", properties.getpropertieserty("UPDATED_TITLE"));
//		map.put("body", properties.getpropertieserty("UPDATED_BODY"));
//		response = HttpClientHandler.requestPutCall(properties.getpropertieserty("VALID_ID"), map);
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		id = jsonPathEvaluator.get("id").toString();
//		CommonUtilities.flushMap(map);
//		Assert.assertFalse(id == properties.getpropertieserty("UPDATED_ID"),
//				"ID field got updated , api not working propertieserly");
//
//	}
//
//	@Test(groups = { "functionalTest" })
//	public void validate_Response_Body_After_Performing_Update_Operation() throws FileNotFoundException {
//		map.put("userId", properties.getpropertieserty("VALID_USER_ID"));
//		map.put("id", properties.getpropertieserty("VALID_ID"));
//		map.put("title", properties.getpropertieserty("UPDATED_TITLE"));
//		map.put("body", properties.getpropertieserty("UPDATED_BODY"));
//		response = HttpClientHandler.requestPutCall(properties.getpropertieserty("VALID_ID"), map);
//		JsonPath jsonPathEvaluator = response.jsonPath();
//		body = jsonPathEvaluator.get("body");
//		CommonUtilities.flushMap(map);
//		Assert.assertEquals(body, properties.getpropertieserty("UPDATED_BODY"), "body did not get updated");
//
//	}

	@AfterTest(groups = { "smoke", "functionalTest" })
	public void tearDown() {

		CommonUtilities.endReport();
	}

}
