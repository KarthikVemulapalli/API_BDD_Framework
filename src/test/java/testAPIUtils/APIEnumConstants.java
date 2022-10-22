package testAPIUtils;

public enum APIEnumConstants {
	AddPlace ("maps/api/place/add/json"),
	DeletePlace ("maps/api/place/delete/json");
	
	String Resource;
	
	APIEnumConstants(String Resource){
		this.Resource = Resource;
	}
	
	public String getResourceURI() {
		return Resource;
	}
}
