package com.sumathi.movies;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sumathi.bookmyshow.MySqlConnectionClass;

public class Movies
{
    public ArrayList getMovies()
    {
    	MovieDetailsBean movie_bean; 
		ArrayList<MovieDetailsBean> list=new ArrayList<MovieDetailsBean>();
		 Statement st=null;
		 ResultSet rs=null;
			try{
			  Connection con=MySqlConnectionClass.getConnection();
			   st=con.createStatement();
			   rs=st.executeQuery("select movie_id,movie_name,movie_desc from Movies");
			//  System.out.println("Movie id" + "  Movie Name" + "Movie desc");
			  while(rs.next())
			  {
				  movie_bean=new MovieDetailsBean();
				  movie_bean.setMovie_id(rs.getInt(1));
				  movie_bean.setMovie_name(rs.getString(2));
				  movie_bean.setMovie_desc(rs.getString(3));
				  list.add(movie_bean);
				 }
			   }
			catch(Exception e)
		{
			e.printStackTrace();
		}
			finally
			{
				if(st!=null)
				{
				  try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
				if(rs!=null)
				{
				  try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    }
}
			return list;
    }
}
