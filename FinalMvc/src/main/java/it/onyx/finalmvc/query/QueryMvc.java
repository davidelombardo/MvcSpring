package it.onyx.finalmvc.query;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class QueryMvc {
public static String getQuery(String query) {
        
        String queryO;
        InputStream fis = null;
        Properties prop = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
    try {
         fis = loader.getResourceAsStream("query.properties");
         prop.load(fis);
        
		} catch (IOException e) {
			System.out.println("EXCEPTION "+e.toString());
			e.printStackTrace();
		}
    queryO = prop.getProperty(query);
    
    return queryO;
    }
}
