package com.sumathi.movieseat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sumathi.bookmyshow.MySqlConnectionClass;

public class MovieSeating{
	public ArrayList getMovieSeat(int show_id)
	{
		SeatBean seat_bean;
		ArrayList<SeatBean> movieSeatList = new ArrayList<SeatBean>();
		try {
			Connection con = MySqlConnectionClass.getConnection();
			Statement st = con.createStatement();
			String seat_status="yes";
			ResultSet rs = st.executeQuery("select * from seatnew where show_id="+show_id+" and seat_status='"+seat_status+"'");
			System.out.println("Sql query..." + rs);
			while (rs.next()) {
				seat_bean=new SeatBean();
				seat_bean.setSeat_id(rs.getString(1));
				seat_bean.setShow_id(rs.getInt(2));
				seat_bean.setSeat_status(rs.getString(3));
				seat_bean.setTheatre_id(rs.getInt(4));
				movieSeatList.add(seat_bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return movieSeatList;
	}
}
