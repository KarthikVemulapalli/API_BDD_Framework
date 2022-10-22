package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import testAPIUtils.Constants;

public class Hooks {
	
	RSMaps RSMapsObj = new RSMaps();

	@Before("@DeletePlace")
	public void beforeDeletePlaceHook() {
		try {
			RSMapsObj.addplace_request_payload(Constants.RSMaps_AddPlace_PhoneNumber);
			RSMapsObj.user_hits_API(Constants.RSMaps_AddPlace, Constants.POST_http);
			RSMapsObj.get_response_payload_value(Constants.RSMaps_AddPlace_PlaceIDMember);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@After("@AddPlace")
	public void afterAddPlaceHook() {
		try {
			RSMapsObj.deleteplace_request_payload();
			RSMapsObj.user_hits_API(Constants.RSMaps_DeletePlace, Constants.DELETE_http);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
