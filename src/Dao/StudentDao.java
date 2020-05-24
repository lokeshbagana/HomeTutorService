package Dao;

import java.sql.*;
import java.util.ArrayList;

import mail.*;

import connection.DatabaseConnection;
import mail.SendingEmail;
import student.StudentDetail;
public class StudentDao {
	
	
	Connection con=null ;
	PreparedStatement pst;
	ResultSet rs;
	public StudentDao() {}
	public String RegisterUser(StudentDetail sd) 
	{
		 String name=sd.getName();
		 long mobile=sd.getMobile();
		 String email=sd.getEmail();
		 String password=sd.getPassword();
		 String gender=sd.getGender();
		 String Address=sd.getAddress();
		 String   dob=sd.getDob();
		 
		 System.out.println("in  STUDEND DAO Servalet");
			/*------------------------Call Connection Class Method--------------------------*/
		 Connection con=DatabaseConnection.getConnection();
		 try
		 {
			/*------------------------Insert data in Student table--------------------------*/
			 PreparedStatement pst=con.prepareStatement("insert into student"
			 		+ "(sname,smobile,semail,spassword,sgender,saddress,sdob,sstatus)"
			 		+ " values(?,?,?,?,?,?,?,?)");
			 
			 	pst.setString(1,name);
				
				pst.setLong(2,mobile);
				
				pst.setString(3,email);
				
				pst.setString(4,password);
				 
				pst.setString(5,gender);
				
				pst.setString(6,Address);
				
				pst.setString(7,dob);
				pst.setInt(8,0);
				
				int i=pst.executeUpdate(); 
				pst.close();
			/*--------------------------- ------------------------------------------------*/
				if(i!= 0)
				{
				
				System.out.println(i+"records inserted");
			/*------------------------Call Sending Email Class--------------------------*/
				SendingEmail se=new SendingEmail();
				System.out.println(email+" psjj");
				boolean mailsent=se.sendMail(email);
				if(mailsent)
				{
					System.out.println("succsess full regidtgdfhdesf");
				
				}
				else
				{
					
					System.out.println(" not succsess full regidtgdfhdesf");
					return "error";
				}
				
				}
		 		
				
		 }catch(Exception e)
		 {
			 System.out.println("Resgidtration exception"+e);
		 }
			   
		
		 return "success";
	}
	public String forgetPassword(StudentDetail sd)
	{
	
			String email=sd.getEmail();
		System.out.println(email);
		/*------------------------Call Connection Class Method--------------------------*/
	 Connection con=DatabaseConnection.getConnection();
	 try
	 {
		/*------------------------select data in Student table--------------------------*/
		 PreparedStatement stmt1=con.prepareStatement("select *from student where semail=? ");
		stmt1.setString(1,email);
		ResultSet rs=stmt1.executeQuery();
		rs.next();
			 
		if(rs.getString(4).equals(email))
		{

		/*------------------------Call Sending Email Class--------------------------*/
			
			SendingEmail se=new SendingEmail();
			System.out.println(email+" psjj");
			boolean mailsent=se.sendMail1(email);
			if(mailsent)
			{
				System.out.println("succsess full send mail");
			}
			else
			{
				System.out.println(" not succsess full send mail");
				return "error";
			}
			
		}
	 		
			
	 }catch(Exception e)
	 {
		 System.out.println("Resgidtration exception"+e);
	 }
		   
	
	 return "success";
	 
}
	
	public ArrayList<StudentDetail> getAllStudent()
	    {
	        ArrayList<StudentDetail> lst = null;
	        
	        try
	        {
	            con = DatabaseConnection.getConnection();
	            
	            pst = con.prepareStatement("select * from student where sstatus = 1");
	            
	            rs = pst.executeQuery();
	            
	            if(rs.isBeforeFirst())
	            {
	                lst = new ArrayList<>();
	                
	                while(rs.next())
	                {
	                    StudentDetail obj = new StudentDetail();
	                    obj.setSid(rs.getInt(1));
	                    obj.setName(rs.getString(2));
	                    obj.setMobile(rs.getLong(3));
	                    obj.setEmail(rs.getString(4));
	                    obj.setPassword(rs.getString(5));
	                    obj.setGender(rs.getString(6));
	                    obj.setAddress(rs.getString(7));
	                    obj.setDob(String.valueOf(rs.getDate(8)));
	                    obj.setSstatus(rs.getInt(9));
	                    
	                    lst.add(obj);
	                }
	            }
	            
	            con.close();
	        }
	        catch(Exception ex)
	        {
	            ex.printStackTrace();
	        }
	        
	        return lst;
	    }
	public ArrayList<StudentDetail> studentProfile(String mail)
    {
        ArrayList<StudentDetail> lst = null;
        System.out.println("I am in Student Profile Mehtod"+mail);
        try
        {
        	
            con = DatabaseConnection.getConnection();
            
            pst = con.prepareStatement("select * from student where semail=?");
            pst.setString(1,mail);
            
            rs = pst.executeQuery();
            
            rs.next();
                lst = new ArrayList<>();
                
               
                    StudentDetail obj = new StudentDetail();
                    obj.setSid(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setMobile(rs.getLong(3));
                    obj.setEmail(rs.getString(4));
                    obj.setGender(rs.getString(6));
                    obj.setAddress(rs.getString(7));
                    obj.setDob(String.valueOf(rs.getDate(8)));
                    obj.setSstatus(rs.getInt(9));
                    
                    lst.add(obj);
                
          
            
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return lst;
    }

}
