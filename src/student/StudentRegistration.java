package student;
  
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import connection.DatabaseConnection;

/**
 * Servlet implementation class StudentRegistration
 */
@WebServlet("/StudentRegistration")
public class StudentRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try{
			System.out.println("in  STUDEND REGISTRATION Servalet");
		/*------------------------Get Student Detail From Form--------------------------*/
		String name=request.getParameter("name");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String dob=request.getParameter("dob");
		
		System.out.println("in  STUDEND REGISTRATION Servalet");
		/*------------------------Set Student Detail into Class--------------------------*/
		StudentDetail sd=new StudentDetail();
		sd.setName(name);
		sd.setMobile(mobile);
		sd.setEmail(email);
		sd.setPassword(password);
		sd.setGender(gender);
		sd.setAddress(address);
		sd.setDob(dob);
		/*------------------------------------------------------------------------------*/	
		StudentDao so=new StudentDao();
		String str=so.RegisterUser(sd);
		System.out.println(str);
		if(str.equals("success"))
		{
			PrintWriter out=response.getWriter();
			out.write("OK");
		}
		else
		{
			PrintWriter out=response.getWriter();
			out.write("NO");
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("STUDEND REGISTRATION "+e);
	}
	}

}
