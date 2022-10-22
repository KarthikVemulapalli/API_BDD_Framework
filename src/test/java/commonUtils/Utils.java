package commonUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public abstract class Utils {	
	
	public static String getCurrentDateTime() {
		Date DateObj = new Date();
		SimpleDateFormat SDFObj = new SimpleDateFormat("ddMMyyyyhhmmss");
		return SDFObj.format(DateObj);
	}
	
	public static String saveLogsPath() {
		String LogPath = System.getProperty("user.dir") + "\\logs\\";
		return (LogPath + "log_" + getCurrentDateTime() + ".txt");
	}
	
	public static String getGlobalPropertyValue(String PropertyName) {
		Properties prop = new Properties();
		FileInputStream FIS = null;
		
		String FilePath = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\global.properties";
		try {
			FIS = new FileInputStream(FilePath);
			prop.load(FIS);
		} catch (Exception e) { e.printStackTrace(); }
		
		return prop.getProperty(PropertyName);
	}

}
