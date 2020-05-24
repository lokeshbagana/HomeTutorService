package student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.DatabaseConnection;

/**
 * Servlet implementation class StudentLoginVerification
 */
@WebServlet("/StudentLoginVerification")
public class StudentLoginVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentLoginVerification() {
        super();
       
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
			
			System.out.println(" I am in StudetloginVerification Servlate");
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			System.out.println(email+" "+password);
		/*-----------------------------------------------*/
			StudentDetail sd=new StudentDetail();
			
			
			Connection con=DatabaseConnection.getConnection();
			try {
			
				PreparedStatement stmt1=con.prepareStatement("select *from student where semail=? and spassword=? and sstatus=?");
				stmt1.setString(1,email);
				stmt1.setString(2,password);
				stmt1.setInt(3,1);
				ResultSet rs=stmt1.executeQuery();
				 rs.next();
				 
					if(rs.getString(4).equals(email) && rs.getString(5).equals(password))
					{
					
						sd.setSid(rs.getInt(1));
						sd.setName(rs.getString(2));
						sd.setMobile(rs.getLong(3));
						sd.setEmail(rs.getString(4));
						sd.setPassword(rs.getString(5));
						sd.setGender(rs.getString(6));
						sd.setAddress(rs.getString(7));
						sd.setDob(String.valueOf(rs.getDate(8)));
						sd.setSstatus(rs.getInt(9));
						
						
						System.out.println("loginsuccsecfiu"+" "+sd.getEmail()+" "+sd.getPassword());
						HttpSession session=request.getSession();
						session.setAttribute("email", sd.getEmail());
						
						PrintWriter out=response.getWriter();
						out.write("YES");
						out.close();
								
					}
					rs.close();
					stmt1.close();
					PrintWriter out=response.getWriter();
					out.write("NO");
					out.close();
			}
			catch(Exception e)
			{
				System.out.println("Login"+e);
		 	}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
