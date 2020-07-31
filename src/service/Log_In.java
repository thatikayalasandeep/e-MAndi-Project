package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import controller.BuyerController;
import controller.DirectorAdminController;
import controller.SellerController;
import dao.DirectorAdminOperations;
import model.Buyer;
import model.Seller;
import utility.ConnectionManager;

   public class Log_In {

	   //object creation
		 Connection con;
		 ConnectionManager cm=new ConnectionManager();
		 BuyerController bc=new BuyerController();
		 SellerController sc=new SellerController();
		 DirectorAdminController dac=new DirectorAdminController();
		 
	public void buyerLogin(Buyer buyer) throws Exception{
		//connection establishing
    	con=cm.getConnection();
    	
    	String email=buyer.getEmail();
    	String password=buyer.getPassword();
    	String query="select * from buyer where email='"+email+"' and password='"+password+"'";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	
         if(rs.next())
    	{
    		String dbemail=rs.getString("email");
    		String dbpassword=rs.getString("password");
    		
       if((email.equals(dbemail)) && (password.equals(dbpassword)))
    	{
    		System.out.println("Your Successfully logined");
    		System.out.println("=========================================================");
    		
    		bc.buyer();
    	}
    	else {
    		System.out.println("email/password incorrect");
    	}
       
    	}else 
    		System.out.println();
	}
    	
	public void sellerLogin(Seller seller) throws Exception{
		//connection establishing
    	con=cm.getConnection();
    	
    	String email=seller.getEmail();
    	String password=seller.getPassword();
    	String query="select * from seller where email='"+email+"' and password='"+password+"'";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	
    	if(rs.next()) {
    		
    		String dbemail=rs.getString("email");
    		String dbpassword=rs.getString("password");
    		
    		
    	if((email.equals(dbemail)) && (password.equals(dbpassword)))
    	{
    		System.out.println("Successfully logined");
    		sc.seller();
    	}
    	else 
    		System.out.println("email/password incorrect");
 
	    }
	}

	public void adminLogin(String email, String password)throws Exception {
		
		//connection establishing
    	con=cm.getConnection();
    	
    	String query="select * from directoradmin where email='"+email+"' and password='"+password+"'";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
   	  //execute statement
    	ResultSet rs=st.executeQuery(query);
   	
         if(rs.next())
    	{
    		String dbemail=rs.getString("email");
    		String dbpassword=rs.getString("password");
    		
       if((email.equals(dbemail)) && (password.equals(dbpassword)))
    	{
    		System.out.println("Your Successfully logined");
    		System.out.println("=========================================================");
    		dac.directorAdmin();
    		;
    	}
    	else {
    		System.out.println("email/password incorrect");
    	}
       
    	}else 
    		System.out.println();
	}
	}


}
