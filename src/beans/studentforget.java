package beans;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.StudentDao;
import student.StudentDetail;

/**
 * Servlet implementation class studentforget
 */
@WebServlet("/studentforget")
public class studentforget extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public studentforget() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			System.out.println("i am in forget ");
			String email=request.getParameter("email");
			StudentDetail sd=new StudentDetail();
			sd.setEmail(email);
			System.out.println("set student detail");
			System.out.println("i  call student dao");
			StudentDao so=new StudentDao();
			String str=so.forgetPassword(sd);
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