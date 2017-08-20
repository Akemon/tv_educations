package application.com.dao;
import java.sql.*;

public class DBConn {
	private String url="jdbc:mysql://localhost:3306/tv_education?characterEncoding=UTF-8";
	private String driver ="com.mysql.jdbc.Driver";
	private String user ="root";
	private String pass ="";
	private Connection connection ;
	public DBConn(){
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public Connection getConnect(){
		return connection;
	}

	public static void main(String[] args) {
		Connection connection =new DBConn().getConnect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet rs =statement.executeQuery("select * from tv_poetry");
			while(rs.next()){
				System.out.println(rs.getString("title"));
			}
		} catch (SQLException e) {
			//
			e.printStackTrace();
		}

	}



}
