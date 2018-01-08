package com.sumathi.moviedate;

import java.sql.Time;
import java.util.Date;

public class ShowDateBean {
int show_id;
public int getShow_id() {
	return show_id;
}
public void setShow_id(int show_id) {
	this.show_id = show_id;
}
public int getTheatre_id() {
	return theatre_id;
}
public void setTheatre_id(int theatre_id) {
	this.theatre_id = theatre_id;
}
public int getMovie_id() {
	return movie_id;
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public Date getShow_date() {
	return show_date;
}
public void setShow_date(Date show_date) {
	this.show_date = show_date;
}
public Time getShow_time() {
	return show_time;
}
public void setShow_time(Time show_time) {
	this.show_time = show_time;
}
int theatre_id;
int movie_id;
Date show_date;
Time show_time;
}
