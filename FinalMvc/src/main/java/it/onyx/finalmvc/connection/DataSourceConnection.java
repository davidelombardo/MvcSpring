package it.onyx.finalmvc.connection;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;




import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class DataSourceConnection {
	 public static MysqlDataSource getMySQLDataSource(String dbName) {
	        Properties props = new Properties();
	        InputStream fis = null;
	        MysqlDataSource mysqlDS = null;
	        ClassLoader loader = Thread.currentThread().getContextClassLoader();

	        try {
	        	fis = loader.getResourceAsStream("datasource.properties");

	           
	            props.load(fis);
	            mysqlDS = new MysqlDataSource();
	            mysqlDS.setURL(props.getProperty("urlDb")+dbName);
	            mysqlDS.setUser(props.getProperty("user"));
	            mysqlDS.setPassword(props.getProperty("password"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return mysqlDS;
	    }
}
