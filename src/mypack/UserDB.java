package mypack;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDB {
	private String dbUrl="jdbc:mysql://localhost:3306/userdb";
	private String dbUser="root";
	private String dbPwd="123456";
	UserDB() throws ClassNotFoundException{
		Class.forName("com.mysql.jdbc.Driver");
	}
	public Connection getConnection()throws Exception{
	      return java.sql.DriverManager.getConnection(dbUrl,dbUser,dbPwd);
	  }
	 public void closeConnection(Connection con){
		    try{
		        if(con!=null) con.close();
		      }catch(Exception e){
		        e.printStackTrace();
		      }
		  }
	 public void register(){
		
	 }
	 //0:验证成功 1：密码错误 或用户名错误 
	 public Integer check(String user,String passwd) throws Exception{
		 Connection con=null;
		 PreparedStatement  stat=null;
		 ResultSet result=null;
		 con=getConnection();
		 String select="select passwd from userdb where user = ?";
		 stat=con.prepareStatement(select);
		 stat.setString(1, user);
		 result=stat.executeQuery();
		 Integer back;
		 if(!result.next()||result.getString(1)!=passwd)back=new Integer(1);
		 else back=new Integer(0);
		 closeConnection(con);
		 return back;
	 }
	 public static void main(String[] args){
		 try {
			UserDB db=new UserDB();
			System.out.println(db.check("yangkangrui", "123456"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	 }
}
