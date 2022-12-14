package testAPIPayload;

public class RSMaps_Payload {

	public static String dataAddPlaceRequestPayload(String PhoneNumber) {
		String AddPlace_RequestBody = "{\r\n" + "  \"location\": {\r\n" + "    \"lat\": 38.383999,\r\n"
				+ "    \"lng\": 33.427999\r\n" + "  },\r\n" + "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Naruto House, JAPAN\",\r\n" + "  \"phone_number\": \""+ PhoneNumber +"\",\r\n"
				+ "  \"address\": \"29, Side layout, Konoro Village 09\",\r\n" + "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"Japaneese\"\r\n" + "}";
		
		return AddPlace_RequestBody;
	}
	
	public static String dataDeletePlaceRequestPayload(String PlaceID) {
		String DeletePlace_RequestBody = "{\"place_id\":\""+PlaceID+"\"}";
		return DeletePlace_RequestBody;
	}
}
