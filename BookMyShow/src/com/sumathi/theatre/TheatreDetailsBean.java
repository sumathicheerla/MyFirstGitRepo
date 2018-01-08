package com.sumathi.theatre;

import java.util.Date;

public class TheatreDetailsBean {
int movie_id;
public int getMovie_id() {
	return movie_id;
}
public void setMovie_id(int movie_id) {
	this.movie_id = movie_id;
}
public int getTheatre_id() {
	return theatre_id;
}
public void setTheatre_id(int theatre_id) {
	this.theatre_id = theatre_id;
}
public String getTheatre_name() {
	return theatre_name;
}
public void setTheatre_name(String theatre_name) {
	this.theatre_name = theatre_name;
}
public String getTheatre_address() {
	return theatre_address;
}
public void setTheatre_address(String theatre_address) {
	this.theatre_address = theatre_address;
}
public Date getRelease_date() {
	return release_date;
}
public void setRelease_date(Date release_date) {
	this.release_date = release_date;
}
int theatre_id;
String theatre_name;
String theatre_address;
Date release_date;
}
