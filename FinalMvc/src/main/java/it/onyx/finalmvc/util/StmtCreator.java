package it.onyx.finalmvc.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StmtCreator {
	public static String getQuery (String query) {
	String outQuery;
	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	InputStream fis=null;
	Properties prop = new Properties();
	
	
	try {
		fis = loader.getResourceAsStream("query.properties");
		prop.load(fis);
	}catch (FileNotFoundException e){
		System.out.println("can't load input-stream");
		e.printStackTrace();
	}catch (IOException e) {
		System.out.println("troubles with properties variable");
	}
	
	outQuery = prop.getProperty(query);
	
	return outQuery;
}
}
