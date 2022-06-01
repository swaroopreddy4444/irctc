package com.javalaya.irctc.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class CommonUtility {
	
	public static String getPropertyValue(String fileName,String key) throws FileNotFoundException{
		
		try (FileInputStream fis = new FileInputStream(".\\testdata\\"+fileName+".properties")){
			Properties p = new Properties();
			p.load(fis);
			
			return p.getProperty(key);
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		return null;
	}

	public static String getCurrentDate() {

		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss"));
	}
	
	
}

