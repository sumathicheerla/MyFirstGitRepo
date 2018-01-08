<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList"%>
 <%@ page import="com.sumathi.movieseat.SeatBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book My Show---Show Timings..</h1>
<h2>Please select Seat...</h2>
<% 
SeatBean seatbean=new SeatBean();
ArrayList<SeatBean> movieSeatList=(ArrayList<SeatBean>)request.getAttribute("movieSeatList"); %>

<table border="2">
<tr>
<td>Show_Id</td>
<td>Seat_Id</td>
</tr>

<% for(int i=0;i<movieSeatList.size();i++)
{
	seatbean=movieSeatList.get(i);%>
    <tr>
    <td><% out.println(seatbean.getShow_id());%></td>
    <td><a href="HelloWorld.jsp"><% out.println(" "+seatbean.getSeat_id());%></a></td>
     </tr>
<% } %>
</table>
</body>
</html>