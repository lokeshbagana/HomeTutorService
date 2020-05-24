<%@page import="Dao.TutorDao"%>
<%@page import="tutor.TutorDetail"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
                        <h2> ALL <b>Tutor List</b></h2>
                    </div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>FirstName</th>
                        <th>MobileNo</th>
                        <th>EMAIL</th>
                        <th>Gender</th>
                        <th>DOB</th>
                        <th>ADDRESS</th>
                        <th>STATUS</th>
                       
                    </tr>
                </thead>
                <tbody>
                    <tbody>
                    <% try {
                            TutorDao dao = new TutorDao();
                            ArrayList<TutorDetail> lst = dao.getAllTutor();

                            for (TutorDetail s : lst) {

                    %>

                    <tr>
                    <th>Id</th>
                        
                        <td><%=s.getTid()%></td>
                        <td><%=s.getName()%></td>
                        <td><%=s.getName()%></td>
                        <td><%=s.getMobile()%></td>
                        <td><%=s.getEmail()%></td>
                        <td><%=s.getGender()%></td>
                        <td><%=s.getDob()%></td>
                        <td><%=s.getAddress()%></td>
                        <td><%=s.getTstatus()%> </td>
                        
                    </tr>

                <%
                        }
                    } catch (Exception e) {

                    }
                %>




                </tbody>
            </table>
            <div class="clearfix">
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Previous</a></li>
                    <li class="page-item active"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item "><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">Next</a></li>
                </ul>
            </div>
        </div>
    </div>
 
        
    </body>
</html>
