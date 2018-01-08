package com.sumathi.moviedate;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sumathi.bookmyshow.MySqlConnectionClass;

public class MovieDates {
	public ArrayList getMovieDates(int movie_id,int theatre_id)
	{
		// TODO Auto-generated method stub
				System.out.println("Enter into ShowTimings servlet..........");
				//MySqlConnectionClass conn=new MySqlConnectionClass();
				ShowDateBean show_bean; 
				ArrayList<ShowDateBean> movieDateList=new ArrayList<ShowDateBean>();
				try{
					  Connection con=MySqlConnectionClass.getConnection();
					  Statement st=con.createStatement();
					  ResultSet rs=st.executeQuery("select * from showtable where movie_id="+movie_id+" and theatre_id="+theatre_id);
					  System.out.println("Sql query..."+rs);
					  while(rs.next())
					  {
						  show_bean=new ShowDateBean();
						  show_bean.setShow_id(rs.getInt(1));
						  show_bean.setTheatre_id(rs.getInt(2));
						  show_bean.setMovie_id(rs.getInt(3));
						  show_bean.setShow_date(rs.getDate(4));
						  show_bean.setShow_time(rs.getTime(5));
						  movieDateList.add(show_bean);
						 }
			}catch(Exception e)
				{
				e.printStackTrace();
			}
			return movieDateList;
	}
}
