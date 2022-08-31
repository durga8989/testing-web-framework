package framework.AllProject;

import java.nio.Buffer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DBTest {
	public static Logger log = LogManager.getLogger(DBTest.class.getName());
	private static Statement stmt;
	static Connection con = null;
	private  static  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static  String DB_URL = "jdbc:mysql://localhost/employees";
	public static  String username = "root";
	public static  String password = "prasada1989";

	@BeforeTest
	public void setUp() throws Exception{
		try {
			String dbclass = "com.mysql.cj.jdbc.Driver";
			Class.forName(dbclass);
			log.info("Connecting to database");
			System.out.println("Connecting to database");
			Connection con = DriverManager.getConnection(DB_URL, "root", "prasada1989");
			log.info("database connection established successfully");
			stmt = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		try {
			
			String sql;
			log.info("Provide the query");
			sql = "select * from titles order by emp_no desc limit 1";
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				/*int emp_no = rs.getInt("emp_no");
				String title = rs.getString("title");*/
				System.out.print("\t" + rs.getString(1));
				System.out.println("\t" + rs.getString(2));
				log.info("output has been displayed");
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@AfterTest
	public void tearDown() throws Exception {
		if(con != null) {
			con.close();
		}
	} 

}
