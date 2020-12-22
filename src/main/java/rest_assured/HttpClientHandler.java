package rest_assured;

import java.util.Map;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.Constants;

public class HttpClientHandler {

	static String baseURI = Constants.BASE_URL;

	// get call for the api
	public static Response requestGetCall(String resource, Map<String,String> queryParamMap) {
		Response response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).queryParams(queryParamMap).
				log().all().when().get(baseURI + resource).then().contentType(ContentType.JSON).log().all().extract()
				.response();
		return response;

	}

	/**
	 * Post Call
	 * 
	 * @param body
	 * @return
	 */
	public static Response requestPostCall(Map body) {
		Response response = RestAssured.given().body(body)
				.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).log().all().when().post(baseURI)
				.then().log().all().extract().response();
		return response;
	}

	/**
	 * PUT call
	 * 
	 * @param resource
	 * @param body
	 * @return
	 */
	public static Response requestPutCall(String resource, Map body) {
		Response response = RestAssured.given().body(body)
				.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).log().all().when()
				.put(baseURI + resource).then().log().all().extract().response();
		return response;
	}

	/**
	 * PATCH call
	 * 
	 * @param resource
	 * @param body
	 * @return
	 */
	public static Response requestPatchCall(String resource, Map body) {
		Response response = RestAssured.given().body(body)
				.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).log().all().when()
				.patch(baseURI + resource).then().log().all().extract().response();
		return response;
	}

	/**
	 * DELETE call
	 * 
	 * @param resource
	 * 
	 * @return
	 */
	public static Response requestDeleteCall(String resource) {
		Response response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.log().all().when().delete(baseURI + resource).then().log().all().extract().response();
		return response;
	}

	/**
	 * Fetch all Details call
	 * 
	 * @return
	 */

	public static Response requestGetCallForAll() {
		Response response = RestAssured.given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.log().all().when().get(baseURI).then().contentType(ContentType.JSON).log().all().extract().response();
		return response;
	}

}
