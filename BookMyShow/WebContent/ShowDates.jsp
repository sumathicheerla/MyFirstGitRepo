<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.ArrayList"%>
 <%@ page import="com.sumathi.moviedate.ShowDateBean"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Book My Show---Show dates..</h1>
<h2>Please select date...</h2>
<% 
ShowDateBean showbean=new ShowDateBean();
ArrayList<ShowDateBean> list=(ArrayList<ShowDateBean>)request.getAttribute("movieDatesList"); %>

<table border="2">
<tr>
<td>Show_Id</td>
<td>Movie_Id</td>
<td>Theatre_Id</td>
<td>Show_Date</td>
</tr>

<% for(int i=0;i<list.size();i++)
{
	showbean=list.get(i);%>
    <tr>
    <td><% out.println(showbean.getShow_id());%></td>
   <td><% out.println(showbean.getMovie_id());%></td>
    <td><% out.println(showbean.getTheatre_id());%></td>
       <td><a href="http://localhost:8080/BookMyShow/BookMyShowControllerNew?req=time&movie_id_time=<%=showbean.getMovie_id()%>&show_date=<%=showbean.getShow_date()%>"><% out.println(" "+showbean.getShow_date());%></a></td>
     </tr>
<% } %>
</table>
</body>
</html>