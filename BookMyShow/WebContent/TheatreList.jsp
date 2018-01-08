<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList"%>
 <%@ page import="com.sumathi.theatre.TheatreDetailsBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book My Show---Theatre list</h1>
<h1>Please select Theatre....</h1>
<% 
TheatreDetailsBean theatrebean=new TheatreDetailsBean();
ArrayList<TheatreDetailsBean> list=(ArrayList<TheatreDetailsBean>)request.getAttribute("theatreList"); %>

<table border="2">
<tr>
<td>Movie_Id</td>
<td>Theatre_Id</td>
<td>Theatre_Name</td>
<td>Theatre_Address</td>
<td>Movie_Release_date</td>
</tr>

<% for(int i=0;i<list.size();i++)
{
	theatrebean=list.get(i);%>
    <tr>
   <td><% out.println(theatrebean.getMovie_id());%></td>
    <td><% out.println(theatrebean.getTheatre_id());%></td>
     <td><a href="http://localhost:8080/BookMyShow/BookMyShowControllerNew?req=date&movie_id=<%=theatrebean.getMovie_id()%>&theatre_id=<%=theatrebean.getTheatre_id()%>"><% out.println(" "+theatrebean.getTheatre_name());%></a></td>
      <td><% out.println(theatrebean.getTheatre_address());%></td>
     <td><% out.println(" "+theatrebean.getRelease_date());%></td>
   </tr>
<% } %>

</table>

</body>
</html>