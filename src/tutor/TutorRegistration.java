package tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import Dao.TutorDao;
import connection.DatabaseConnection;
import student.StudentDetail;

/**
 * Servlet implementation class TutorRegistration
 */
@WebServlet("/TutorRegistration")
public class TutorRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TutorRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("I am in Servlet"+request.getParameter("name"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.println("in Servalet");
		String name=request.getParameter("name");
		long mobile=Long.parseLong(request.getParameter("mobile"));
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String dob=request.getParameter("dob");
		String qualification=request.getParameter("qualification");
		System.out.println("in Servalet");
		
		/*-----------------------------------------------*/
			TutorDetail td=new TutorDetail();
			td.setName(name);
			td.setMobile(mobile);
			td.setEmail(email);
			td.setPassword(password);
			td.setGender(gender);
			td.setAddress(address);
			td.setDob(dob);	
			td.setQualification(qualification);
			
		/*-----------------------------------------------*/	
			
			
			TutorDao to=new TutorDao();
			String str=to.RegisterUser1(td);
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
			System.out.println(e);
		}
		
	}

}
