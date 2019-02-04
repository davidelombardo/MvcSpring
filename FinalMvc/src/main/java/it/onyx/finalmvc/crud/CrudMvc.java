package it.onyx.finalmvc.crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import it.onyx.finalmvc.connection.DataSourceConnection;
import it.onyx.finalmvc.dao.DaoMvc;
import it.onyx.finalmvc.util.StmtCreator;

public class CrudMvc {
	String firstName, lastName, num, id, email, password;
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
public DaoMvc selectUser (String email, String password ) {
		
		
	Statement stmt=null;
	DataSource dc =DataSourceConnection.getMySQLDataSource("videoteca"); 
	ResultSet res = null;
	 DaoMvc ud = (DaoMvc) context.getBean("DaoMvc");
	 Connection con= null;
		
		
		try {
			con = dc.getConnection();
			stmt = con.createStatement();
			System.out.println(StmtCreator.getQuery("selectCliente1")+email+StmtCreator.getQuery("andPwd")+password+"'");
			res = stmt.executeQuery(StmtCreator.getQuery("selectCliente1")+email+StmtCreator.getQuery("andPwd")+password+"'");
			res.next();
				ud.setEmail(res.getString("email"));
				ud.setPassword(res.getString("password"));
				System.out.println("Query eseguita");
				
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("il problema e' qui");
		}finally {
			try {
				stmt.close();
				res.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		return ud;
	}
}
