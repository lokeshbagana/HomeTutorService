<%@page import="connection.DatabaseConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@
page import ="java.sql.*"
 %>
<%@
page import="java.io.IOException"
 %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<p>Tutor</p>

<%
String email=request.getParameter("key1");
System.out.println(email);
Connection con=DatabaseConnection.getConnection();
try
{
	
	System.out.println("Activate Account Login again");
	PreparedStatement pts=con.prepareStatement("select temail,tstatus from tutor where temail=? and tstatus=?");
	pts.setString(1,email);
	pts.setInt(2,0);
	ResultSet rs=pts.executeQuery();
	
	if(rs.next())
	{
		PreparedStatement pts1=con.prepareStatement("update tutor set tstatus=? where temail=?");
				pts1.setInt(1,1);
				pts1.setString(2,email);
		int i=pts1.executeUpdate();
			if(i!=0)
			{
				response.sendRedirect("TutorForm.html");  
			}
			else
			{
				response.sendRedirect("index.jsp");
			}
		
	}
	
	
}
catch(Exception e)
{
	System.out.println("Activate Account"+e);
}


%>
<h>email veridsjbjfh<h>
</body>
</html>