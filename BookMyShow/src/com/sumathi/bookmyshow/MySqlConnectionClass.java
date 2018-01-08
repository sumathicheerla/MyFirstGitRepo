package com.sumathi.bookmyshow;
import java.sql.Connection;
import java.sql.DriverManager;

public  class  MySqlConnectionClass 
{
	 static Connection con = null;
	private MySqlConnectionClass()
	{
		
	}
  public static Connection getConnection()
  {
	try{
		if(con==null)
		{
	  Class.forName("com.mysql.jdbc.Driver");
	  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookmyshowdb","sumathi","sumathi");
		  
	  }
	}catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	 return con;
  }
}


