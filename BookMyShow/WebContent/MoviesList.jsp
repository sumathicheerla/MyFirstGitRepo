<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.ArrayList"%>
 <%@ page import="com.sumathi.movies.MovieDetailsBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="TheatresDisplay" method="get">
<h1>Book My Show----Movies list</h1>
<h2>Please select Movie....</h2>
<% MovieDetailsBean moviebean=new MovieDetailsBean();
ArrayList<MovieDetailsBean> list=(ArrayList<MovieDetailsBean>)request.getAttribute("movieList"); 
%>
<table border="2">
<tr>
<td>Movie_Id</td>
<td>Movie_Name</td>
<td>Movie_Desc</td>
</tr>
<% for(int i=0;i<list.size();i++)
{
    moviebean=list.get(i);
    %>
    <tr>
   <td><% out.println(moviebean.getMovie_id());%></td>
   <td><a href="http://localhost:8080/BookMyShow/BookMyShowControllerNew?req=theatre&name=<%=moviebean.getMovie_name()%>"><% out.println(" "+moviebean.getMovie_name());%></a></td>
    <td><% out.println(moviebean.getMovie_desc());%></td>
   </tr>
   <% } %>
</table>
</form>
</body>
</html>