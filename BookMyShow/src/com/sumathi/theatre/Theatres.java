package com.sumathi.theatre;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sumathi.bookmyshow.MySqlConnectionClass;

public class Theatres {
	public ArrayList getTheatres(String MovieName) {
		// MySqlConnectionClass conn=new MySqlConnectionClass();
		TheatreDetailsBean theatre_bean;
		ArrayList<TheatreDetailsBean> list = new ArrayList<TheatreDetailsBean>();
		try {
			Connection con = MySqlConnectionClass.getConnection();
			Statement st = con.createStatement();
			ResultSet rs = st
					.executeQuery("select * from theatre where movie_id=(select movie_id from Movies where movie_name='"
							+ MovieName + "')");
			while (rs.next()) {
				theatre_bean = new TheatreDetailsBean();
				theatre_bean.setMovie_id(rs.getInt(1));
				theatre_bean.setTheatre_id(rs.getInt(2));
				theatre_bean.setTheatre_name(rs.getString(3));
				theatre_bean.setTheatre_address(rs.getString(4));
				theatre_bean.setRelease_date(rs.getDate(5));
				list.add(theatre_bean);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
