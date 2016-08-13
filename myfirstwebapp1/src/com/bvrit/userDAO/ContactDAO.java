package com.bvrit.userDAO;
import java.util.List;
import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
//import java.util.Collection;


import com.bvrith.model.ContactBean;
//import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

//import javax.servlet.http.HttpSession;

public class ContactDAO {
	Statement st=null;
	Connection conn = null;
	public ContactDAO() throws SQLException {
		 ConnectionDAO connDAO = new ConnectionDAO();
		 conn = connDAO.getConnection();
		 st = conn.createStatement();
	}
	
	public int addContact(ContactBean cBean) throws SQLException{
	      int result;
	      String user = cBean.getUser();
	        String id = cBean.getId();
	        String name = cBean.getName();
	        String email = cBean.getEmail();
	        String phone = cBean.getPhone();
	        
			String query = "insert into contactinfo values('"+id+"','"+name+"','"+email+"','"+phone+"','"+user+"')"; 	
			
           System.out.println(st);
           //execute query
           result = st.executeUpdate(query);
           System.out.println("Query excecuted");
           System.out.println(result);
           if(conn != null){
        	   conn.close();
           }
           if(st != null){
        	   st.close();
           }
          
           return result;
	}
	
	
	public int deleteContact(String id) throws SQLException{
		System.out.println(id);
		String query = "delete from contactinfo where id='"+id+"'";
		 //execute query
        int result = st.executeUpdate(query);
        System.out.println("Query delete excecuted");
        System.out.println(result);
        if(conn != null){
     	   conn.close();
        }
        if(st != null){
     	   st.close();
        }
       
        return result;
	}
	
	public List<ContactBean> listContact(String user) throws SQLException,ClassNotFoundException{
		List<ContactBean> conCollection = new ArrayList<ContactBean>();
		String query = "SELECT * FROM contactinfo where user='"+user+"'";
		ResultSet result = st.executeQuery(query);
		ContactBean contactBean2;
		while(result.next()){
	           //Retrieve by column name
	          
	           String  id = result.getString("id");
	           String  name = result.getString("name");
	           String  email = result.getString("email");
	           String  phone = result.getString("phone");
	           String  username = result.getString("user");
	           contactBean2 = new ContactBean(id,name,email,phone,username);
	           conCollection.add(contactBean2);
		}
		System.out.println(conCollection.size());
		return conCollection;
	}

	public int updateContact(ContactBean cBean) throws SQLException{	
		
		 int result;
	   //   String user = cBean.getUser();
	        String id = cBean.getId();
	        String name = cBean.getName();
	        String email = cBean.getEmail();
	        String phone = cBean.getPhone();
		
		String query = "UPDATE contactinfo set name ='"+name+"',email='"+email+"',phone='"+phone+"' where id ='"+id+"'";		       	
            result = st.executeUpdate(query);
            if(result>=1){
                System.out.println("contact updated");
            }else{
                System.out.println("contact not updated");
                conn.close();
                st.close();
                result = 0;
            }
            conn.close();
            st.close();
            return result;	   	       	    						
}

}
