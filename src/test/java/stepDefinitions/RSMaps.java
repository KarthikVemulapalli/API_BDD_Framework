package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testAPIPayload.*;
import testAPIUtils.APIEnumConstants;
import testAPIUtils.APIUtils;
import testAPIUtils.Constants;

public class RSMaps extends APIUtils {
	
	private RequestSpecification APIReqSpec;
	private Response APIResponse;
	private APIEnumConstants APIConstantsObj;
	
	public static String AddPlace_RsB_PlaceID;

	
	@Given("AddPlace Request Payload with {string}")
	public void addplace_request_payload(String PhoneNo) {
		APIReqSpec = given().spec(RSMaps_ReqSpecBuild()).
			queryParam(Constants.RSMaps_APIKey, Constants.RSMaps_APIValue).
			//body(RSMaps_Payload.dataAddPlaceRequestPayload(Constants.RSMaps_AddPlace_PhoneNumber));
			body(RSMaps_Payload.dataAddPlaceRequestPayload(PhoneNo));
	}
	
	@When("User hits {string} API with {string} http request")
	public void user_hits_API(String APIName, String APIHTTPRequest) {
		
		APIConstantsObj = APIEnumConstants.valueOf(APIName); 
		
		if(APIName.equalsIgnoreCase(Constants.RSMaps_AddPlace) || APIHTTPRequest.equalsIgnoreCase(Constants.POST_http)) {   //We got data using Interface
			APIResponse = APIReqSpec.when().
					post(APIConstantsObj.getResourceURI());			//We got data using Enum
		} else if (APIName.equalsIgnoreCase(Constants.RSMaps_DeletePlace) || APIHTTPRequest.equalsIgnoreCase(Constants.DELETE_http)) {
			APIResponse = APIReqSpec.when().
					delete(APIConstantsObj.getResourceURI());
		}
	}
	
	@Then("API call response with status code {int}")
	public void api_call_response_with_statuscode(int StatusCode) {
		APIResponse.then().spec(RSMaps_ResSpecBuild()).
			assertThat().statusCode(StatusCode);
		
		/* assertEquals(APIResponse.statusCode(), StatusCode); */
	}
	
	@And("Validate Response Payload {string} is {string}")
	public void validate_response_payload(String MemberName, String MemberValue) {
		/* APIResponse.then().
			assertThat().body(MemberName, equalTo(MemberValue)); */
		
		assertEquals(getMemberValueUsingJsonPath(APIResponse, MemberName), MemberValue);
	}
	
	@Given ("DeletePlace Request Payload")
	public void deleteplace_request_payload() {
		APIReqSpec = given().spec(RSMaps_ReqSpecBuild()).
				queryParam(Constants.RSMaps_APIKey, Constants.RSMaps_APIValue).
				body(RSMaps_Payload.dataDeletePlaceRequestPayload(AddPlace_RsB_PlaceID));
	}
	
	@And("Get Response Payload {string} value")
	public void get_response_payload_value(String MemberName) {
		String Response_MemberName = getMemberValueUsingJsonPath(APIResponse, MemberName); 
		if(MemberName.equalsIgnoreCase(Constants.RSMaps_AddPlace_PlaceIDMember)) {
			AddPlace_RsB_PlaceID = Response_MemberName;
		}
	}

}
