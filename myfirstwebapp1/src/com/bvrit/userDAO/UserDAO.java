package com.bvrit.userDAO;

import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.bvrith.model.UserBean;

//import com.sun.crypto.provider.RSACipher;

public class UserDAO {
	Statement st=null;
	Connection conn = null;
	public UserDAO() throws SQLException {
		ConnectionDAO connDAO = new ConnectionDAO();
		 conn = connDAO.getConnection();
		 st = conn.createStatement();
	}

	public int createUser(UserBean uBean) {
		int result = 0;
		String user = uBean.getUser();
        String password = uBean.getPassword();
		String query = "insert into users values('"+user+"','"+password+"')";	       
	
		System.out.println(st);
            //execute query
		System.out.println(result);
		 try {
			result = st.executeUpdate(query);
			
		} catch (SQLException e1) {
			result = 0;
			
			e1.printStackTrace();
		}  
           try{ 
            if(conn != null){
                conn.close();
                }
            if(st != null){
            	st.close();
            	}
           }
           catch(Exception e){
        	   e.printStackTrace();
           }
            System.out.println(result);
            return result;
 
	}

	public boolean validateUser(UserBean uBean) throws SQLException{
		String user = uBean.getUser();
        String password = uBean.getPassword();
		 	ResultSet rs = null;			
			String sql = "SELECT * FROM users";					
			System.out.println("connected");
	        rs = st.executeQuery(sql);
	         System.out.println("query excecuted");
	         while(rs.next()){
	        	 String first = rs.getString("username");
	             String last = rs.getString("password");
	        	 if(user.equals(first) && password.equals(last)){
	        		 conn.close();
		        	  st.close();
		        	  rs.close();
		        	  return true;
	        	 }
	         }
			return false;	      
	}
	
	public int updateUser(String user,String pwd1,String pwd2) throws SQLException{	
			String query = "update users set password='"+pwd2+"' where username='"+user+"' && password='"+pwd1+"';";		       	
	            int result = st.executeUpdate(query);
	            if(result>=1){
	                System.out.println("Record updated");
	            }else{
	                System.out.println("Record not updated");
	                conn.close();
	                st.close();
	                return 0;
	            }
	            conn.close();
                st.close();
	            return 1;	   	       	    						
	}
	
}
