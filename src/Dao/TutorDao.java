package Dao;
import mail.SendingEmail;
import java.sql.*;
import java.util.ArrayList;

import mail.*;

import connection.DatabaseConnection;
import mail.SendingEmail;
import student.StudentDetail;
import tutor.TutorDetail;
public class TutorDao {
	

Connection con ;
PreparedStatement pst;
ResultSet rs;
	public TutorDao() {}
	public String RegisterUser1(TutorDetail td) 
	{
		 String name=td.getName();
		 long mobile=td.getMobile();
		 String email=td.getEmail();
		 String password=td.getPassword();
		 String gender=td.getGender();
		 String Address=td.getAddress();
		 String   dob=td.getDob();
		 String qualification=td.getQualification();
		 
		 System.out.println("in  TUTOR DAO Servalet");
			/*------------------------Call Connection Class Method--------------------------*/
		 Connection con=DatabaseConnection.getConnection();
		 try
		 {
			/*------------------------Insert data in Tutor table--------------------------*/
			 PreparedStatement pst=con.prepareStatement("insert into tutor"
			 		+ "(tname,tmobile,temail,tpassword,tgender,tdob,tqualification,taddress,tstatus)"
			 		+ " values(?,?,?,?,?,?,?,?,?)");
			 
			 	pst.setString(1,name);
				
				pst.setLong(2,mobile);
				
				pst.setString(3,email);
				
				pst.setString(4,password);
				 
				pst.setString(5,gender);
				
				pst.setString(6,dob);
				
				
				pst.setString(7,qualification);
				
				pst.setString(8,Address);
				
				
				pst.setInt(9,0);
				
				int i=pst.executeUpdate(); 
				pst.close();
			/*--------------------------- ------------------------------------------------*/
				if(i!= 0)
				{
				
				System.out.println(i+"records inserted");
			/*------------------------Call Sending Email Class--------------------------*/
				SendingEmailTutor se=new SendingEmailTutor();
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
	
	
	
	public ArrayList<TutorDetail> getAllTutor()
    {
        ArrayList<TutorDetail> lst = null;
        
        try
        {
            con = DatabaseConnection.getConnection();
            
            pst = con.prepareStatement("select * from tutor");
            
            rs = pst.executeQuery();
            
            if(rs.isBeforeFirst())
            {
                lst = new ArrayList<>();
                
                while(rs.next())
                {
                    TutorDetail obj = new TutorDetail();
                    obj.setTid(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setMobile(rs.getLong(3));
                    obj.setEmail(rs.getString(4));
                    obj.setPassword(rs.getString(5));
                    obj.setGender(rs.getString(6));
                    obj.setDob(String.valueOf(rs.getDate(7)));
                    obj.setDob(rs.getString(8));
                    obj.setAddress(rs.getString(9));
                    obj.setTstatus(rs.getInt(10));
                    
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
	public ArrayList<TutorDetail> tutorProfile(String mail)
    {
        ArrayList<TutorDetail> lst = null;
        
        try
        {
        	con = DatabaseConnection.getConnection();
            
            pst = con.prepareStatement("select * from tutor where temail=?");
            pst.setString(1,mail);
            
            rs = pst.executeQuery();
            
            rs.next();
                lst = new ArrayList<>();
                
                {
                    TutorDetail obj = new TutorDetail();
                    obj.setTid(rs.getInt(1));
                    obj.setName(rs.getString(2));
                    obj.setMobile(rs.getLong(3));
                    obj.setEmail(rs.getString(4));
                    obj.setGender(rs.getString(6));
                    obj.setDob(String.valueOf(rs.getDate(7)));
                    obj.setDob(rs.getString(8));
                    obj.setAddress(rs.getString(9));
                    obj.setTstatus(rs.getInt(10));
                    
                    lst.add(obj);
                }
           
            
            con.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        return lst;
    }
}
