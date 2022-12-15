package testAPIUtils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import commonUtils.Utils;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class APIUtils {
	
	private static RequestSpecification ReqSpec;
	private static ResponseSpecification ResSpec;
	
	protected RequestSpecification RSMaps_ReqSpecBuild() {
		try {
			if(ReqSpec == null) {
				PrintStream printstream = new PrintStream(new FileOutputStream(Utils.saveLogsPath()));
				ReqSpec = 
						new RequestSpecBuilder().
//							setBaseUri(Constants.RSMaps_APIBaseURI).  				//From Constants File
							setBaseUri(Utils.getGlobalPropertyValue("RSMaps_APIBaseURI")).		//From Properties file
							setContentType(ContentType.JSON).
//							log(LogDetail.ALL).
							addFilter(RequestLoggingFilter.logRequestTo(printstream)).
							addFilter(ResponseLoggingFilter.logResponseTo(printstream)).
							build();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return ReqSpec;
	}
	
	protected ResponseSpecification RSMaps_ResSpecBuild() {
		ResSpec = 
			new ResponseSpecBuilder().
//				log(LogDetail.ALL).
				build();
		return ResSpec;
	}
	
	protected String getMemberValueUsingJsonPath(Response APIResponse, String MemberJsonPath) {
		String APIStringResponse = APIResponse.asString();
		JsonPath APIJsonResponse = new JsonPath(APIStringResponse);
		return APIJsonResponse.getString(MemberJsonPath).trim();
	}
}
