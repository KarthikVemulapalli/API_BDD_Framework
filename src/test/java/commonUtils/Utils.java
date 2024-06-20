package commonUtils;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public abstract class Utils {	
	
	public static String getCurrentDateTime() {
		Date DateObj = new Date();
		SimpleDateFormat SDFObj = new SimpleDateFormat("ddMMyyyyhhmmss");
		return SDFObj.format(DateObj);
	}
	
	public static String saveLogsPath() {
		String LogPath = System.getProperty("user.dir") + "\\reports\\";
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
