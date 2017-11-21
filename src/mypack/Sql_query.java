package mypack;//将第三方提供的jar文件包设置成为system library（window-preference-java-userlibraries打上勾使得成为system library），然后在工程中添加这个user library，

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sql_query {
	public static void main( String[] args ){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//java.sql.DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String bookdb="jdbc:mysql://localhost:3306/bookdb";
		Connection con=null;
		Statement stmt = null;
		PreparedStatement pre=null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(bookdb, "young", "123456");
			//String insert="insert into books values('201','孙卫琴','java面向对象编程',15.10,2010,'深入理解面向对象',1)";
			String sql="select * from books";
			stmt=con.createStatement();
			//stmt.executeQuery(insert);
			rs=stmt.executeQuery(sql);
			while(rs.next()){
				String col1=rs.getString(1);
				String col2=rs.getString(2);
				String col3=rs.getString(3);
				String col4=rs.getString(4);
				System.out.println("ID="+col1+"NAME="+col2+"TITLE="+col3+"PRICE"+col4);
			}
			pre=con.prepareStatement("insert into books (id,yr) values(?,?)");
			pre.setString(1, "216");
			pre.setString(2, "20.4");
			pre.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		   try {
			   	if(rs!=null)rs.close();
			   	if(stmt!=null)stmt.close();
			   	if(con!=null)con.close();
		   } catch (SQLException e) {
			   // TODO Auto-generated catch block
			   	System.out.println("未建立连接");
			   	e.printStackTrace();
		   		}
		}
	}
}
