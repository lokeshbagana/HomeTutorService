package tutor;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DatabaseConnection;
import student.StudentDetail;

/**
 * Servlet implementation class tutorLoginVerification
 */
@WebServlet("/tutorLoginVerification")
public class tutorLoginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public tutorLoginVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(" I am in TutorloginVerification Servlate");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		System.out.println(email+" "+password);
	/*-----------------------------------------------*/
		TutorDetail td=new TutorDetail();
		
		
		Connection con=DatabaseConnection.getConnection();
		try {
		
			PreparedStatement stmt1=con.prepareStatement("select *from tutor where temail=? and tpassword=? and tstatus=?");
			stmt1.setString(1,email);
			stmt1.setString(2,password);
			stmt1.setInt(3,1);
			System.out.println("done");
			ResultSet rs1=stmt1.executeQuery();
			rs1.next();
			System.out.println("done");
				if(rs1.getString(4).equals(email) && rs1.getString(5).equals(password))
				{
					System.out.println("done");
					td.setTid(rs1.getInt(1));
					td.setName(rs1.getString(2));
					td.setMobile(rs1.getLong(3));
					td.setEmail(rs1.getString(4));
					td.setPassword(rs1.getString(5));
					td.setGender(rs1.getString(6));
					td.setDob(String.valueOf(rs1.getDate(7)));
					td.setQualification(rs1.getString(8));
					td.setAddress(rs1.getString(9));
					td.setTstatus(rs1.getInt(10));
					
					
					System.out.println("loginsuccsecfiu"+" "+td.getEmail()+" "+td.getPassword());
					HttpSession session=request.getSession();
					session.setAttribute("email", td.getEmail());
					PrintWriter out=response.getWriter();
					out.write("YES");
					out.close();
							
				}
				PrintWriter out=response.getWriter();
				out.write("NO");
				out.close();
		}
		catch(Exception e)
		{
			System.out.println("Login"+e);
	 	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
