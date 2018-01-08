package com.sumathi.movietime;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sumathi.bookmyshow.MySqlConnectionClass;
import com.sumathi.moviedate.ShowDateBean;

public class MovieTimings
{
  public ArrayList getMovieTimings(int movie_id,String show_date )
  {
	  System.out.println("Enter into ShowTimings servlet..........");
		//MySqlConnectionClass conn = new MySqlConnectionClass();
		ShowDateBean show_bean;
		ArrayList<ShowDateBean> movieTimeList = new ArrayList<ShowDateBean>();
		try {
		
			Connection con = MySqlConnectionClass.getConnection();
			Statement st = con.createStatement();
			//"select * from theatre where movie_id=(select movie_id from Movies where movie_name='"+MovieName+"')");
			
			ResultSet rs = st.executeQuery("select * from showtable where movie_id="+movie_id+" and show_date='"+show_date+"'");
			System.out.println("Sql query..." + rs);
			while (rs.next()) {
				show_bean=new ShowDateBean();
				  show_bean.setShow_id(rs.getInt(1));
				  show_bean.setTheatre_id(rs.getInt(2));
				  show_bean.setMovie_id(rs.getInt(3));
				  show_bean.setShow_date(rs.getDate(4));
				  show_bean.setShow_time(rs.getTime(5));
				  movieTimeList.add(show_bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieTimeList;
  }
}
