package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

import model.Buyer;
import model.ProductDetails;
import model.SellerDetails;
import model.UserDetails;
import utility.ConnectionManager;

public class DirectorAdminOperations {
	
    //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();
	  
  public void editProfile(long adminid1)throws Exception {
	  
	//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 System.out.println();
		 
		 //taking input from user
		 System.out.println("enter new/old ID");
	     long yourid=Long.parseLong(br.readLine()); 
	     System.out.println("enter new/old firstname");
	     String firstname=br.readLine(); 
	     System.out.println("enter new/old lastname");
	     String lastname=br.readLine(); 
	     System.out.println("enter new/old email");
	     String email=br.readLine();
	     System.out.println("enter new/old phone number");
	     String phone=br.readLine();
	     System.out.println("enter new/old pasword number");
	     String password=br.readLine();
	     
	     //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE admindirector SET adminid=?,firstname=?,lastname=?,email=?,phone=?,password1=? where ADMINID="+adminid1);
	     
	     //setting values into table
	     ps.setLong(1, yourid);
	     ps.setString(2, firstname);
	     ps.setString(3, lastname);
	     ps.setString(4, email);
	     ps.setString(5, phone);
	     ps.setString(6, password);
	     
	   //processing prepare statement
	     int count=ps.executeUpdate();
	     System.out.println(count+"row/s Profile updated succesfully");
	     
	     //closing all connections
		 ps.close();	
		 con.close();
		
	}

  
  
     public void addUser(UserDetails user) throws Exception {
    	 
         //calling method of getConnection in ConnectionManager class
    	 con=cm.getConnection();
    	 
    	 //creating prepare statement
    	 PreparedStatement ps=con.prepareStatement("insert into userdetails(user_ID,user_firstname,user_lastname,email,phone,user_type)values(?,?,?,?,?,?)");
    	 
    	 //setting values into database
         ps.setLong(1, user.getUserid());
    	 ps.setString(2, user.getFirstname());
    	 ps.setString(3, user.getLastname());
    	 ps.setString(4, user.getEmail());
    	 ps.setString(5, user.getPhone());
    	 ps.setString(6, user.getUsertype());
    	 
    	 //executing prepare statement
    	 int count=ps.executeUpdate();
    	 
 		 System.out.println(count+"User added successfully");
 		 
 		 //close all connections
 		 ps.close();	
    	 con.close();
    	 }
     
     public void updateUser(Long user_id) throws Exception {
    
    //calling method of getConnection in ConnectionManager class	 
	 con=cm.getConnection();
	 
	 //creating prepare statement
	 PreparedStatement ps=con.prepareStatement("UPDATE userdetails SET user_firstname=?,user_lastname=?,email=?,phone=?,user_type=? where user_ID="+user_id);
	 
	 //taking input from user
     System.out.println("enter firstname");
     String firstname=br.readLine(); 
     System.out.println("enter lastname");
     String lastname=br.readLine(); 
     System.out.println("enter email");
     String email=br.readLine();
     System.out.println("enter phone number");
     String phone=br.readLine();
     System.out.println("enter user type");
     String usertype=br.readLine();
     
     //setting values into table
     ps.setString(1, firstname);
     ps.setString(2, lastname);
     ps.setString(3, email);
     ps.setString(4, phone);
     ps.setString(5, usertype);
    
     //processing prepare statement
     int count=ps.executeUpdate();
     System.out.println(count+"user updated succesfully");
     
     //closing all connections
		ps.close();	
 	    con.close();
    }
     
     public void removeUSer(Long id_user) throws Exception {
    	 
    	//calling method of getConnection in ConnectionManager class 
	     con=cm.getConnection();
	     
	     //creating prepare statement
	     PreparedStatement ps=con.prepareStatement("DELETE FROM userdetails where user_ID="+id_user);
	     
	     //executing prepare statement
	     int count=ps.executeUpdate();
	     
	     System.out.println(count+"user deleted succusfully");
	     
	     //closing all connections
		 ps.close();	
	 	 con.close();
     }
    public void viewUserList() throws Exception {
    	
    	//connection establishing
    	con=cm.getConnection();
    	String query="select * from Userdetails ";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	System.out.println();
    	System.out.println("Users_id      user_firstname      user_last_name      phone_number      user_type");
    	System.out.println("__________________________________________________________________________________________");
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"  "+rs.getString(4)+"    "+rs.getString(5)+"      "+rs.getString(6));
        System.out.println("__________________________________________________________________________________________");
    	}
        //closing all connections
        st.close();
        con.close();
    } 
	public void addProduct(ProductDetails product) throws Exception {
		
		//connection establishing
	     con=cm.getConnection();
	     
	     //creating Prepare statement
	    PreparedStatement ps=con.prepareStatement("insert into productdetails(product_ID,productname,cost_1KG,quantity)values(?,?,?,?)");
        
	    //setting values into table
		ps.setInt(1, product.getProduct_ID());
		ps.setString(2, product.getProductname());
		ps.setFloat(3, product.getCost());
		ps.setLong(4, product.getQuantity());
		
		//proceed Prepare Statement
		 int count=ps.executeUpdate();
    	 
		System.out.println(count+"successfully added");
		
		//closing all connections	
		ps.close();	
 	    con.close();
	
	}
	public void productUpdate(String productname) throws Exception{
		
		//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 
		 System.out.println();
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE productdetails SET productname=?,COST_1KG=?,quantity=? where productname='"+productname+"'");
		 
		 //taking input from user
		 System.out.println("enter vegetable cost per kg");
		 float cost=Float.parseFloat(br.readLine());
		 System.out.println("enter vegetable quatity");
		 long quantity=Long.parseLong(br.readLine());
		 
		 //setting values
		 ps.setString(1, productname);
		 ps.setFloat(2, cost);
		 ps.setLong(3, quantity);
		
		//processing prepare statement
		 int count=ps.executeUpdate();
		 
		 System.out.println(count+"row/s vegetable information updated succesfully");
		 
		 // closing all connections 
			ps.close();	
	 	   con.close();
		 
	}
	public void removeProduc(String productname) throws Exception{
		//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 
		 System.out.println();
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("delete from  productdetails where productname='"+productname+"'" );
		 
		//processing prepare statement
		 int count=ps.executeUpdate();
		 
		 System.out.println(count+"row/s vegetable vegetable succesfully");
		 
		 // closing all connections 
			ps.close();	
	 	   con.close(); 
	
	}
     
	public void viewProductList() throws Exception  {
		
        //connection establishing
        con=cm.getConnection();
        
      //writing query
        String query="select * from productdetails ORDER BY  productname ASC ";
        
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	System.out.println();
    	System.out.println("Product_id        Product_name       Cost_1KG        Available_Quantity");
    	System.out.println("_______________________________________________________________________________________");
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getInt(1)+"              "+rs.getString(2)+"         "+rs.getFloat(3)+"      "+rs.getLong(4));
        System.out.println("_______________________________________________________________________________________________");
    	}
        //closing all connections
        st.close();
        con.close();
		
	}

	 public void viewProfile(long adminid)throws Exception{
		  
			//calling method of getConnection in ConnectionManager class
				 con=cm.getConnection();
				 System.out.println();
				 
				 //writing query
				 String query="select * from admindirector where  ADMINID="+adminid;
				//create statement
			 	Statement st=con.createStatement();
			 	
			 	//execute statement
			 	ResultSet rs=st.executeQuery(query);
			 	System.out.println();
			 	System.out.println("Admin_id    first_name      last_name   email     phone_number    password ");
			 	System.out.println();
			 	while(rs.next()){
			 		
			 	//fetching values
			     System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6));
			 	}
			     //closing all connections
			     st.close();
			     con.close();
			}

	public void searchBuyer(long buyer_id)throws Exception {
		
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	  System.out.println();
	  	  
	  	 //writing query
	  	  String query="select * from userdetails where  user_ID="+buyer_id;
	  	  
	  	//create statement
	    Statement st=con.createStatement();
	    	
	    //execute statement
	    ResultSet rs=st.executeQuery(query);
	    
	    if(rs.next()) {
	 		    		
	 		    	do {
	 		  	    
	 		  	    System.out.println("User_ID        firstname     lastname    email    phone  user_type");
	 		  	    System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"  "+rs.getString(4)+"    "+rs.getString(5)+"      "+rs.getString(6));
	 		    	}while(rs.next());
	
	 		    }
	 		    else {
	 		    		
	 		    		System.out.println("Sorry this Buyer not exist");
	 		    	}
	 	      
	  //closing statement
		    st.close();
		    con.close();
		
	}



	public void addSeller(SellerDetails seller)throws Exception{
		
		 //calling method of getConnection in ConnectionManager class
   	 con=cm.getConnection();
   	 
   	 //creating prepare statement
   	 PreparedStatement ps=con.prepareStatement("insert into sellerdetails(userid,firstname,lastname,email,phone)values(?,?,?,?,?)");
   	 
   	 //setting values into database
     ps.setLong(1, seller.getUserid());
   	 ps.setString(2, seller.getFirstname());
   	 ps.setString(3, seller.getLastname());
   	 ps.setString(4, seller.getEmail());
   	 ps.setString(5, seller.getPhone());
   	 
   	 //executing prepare statement
   	 int count=ps.executeUpdate();
   	 
		 System.out.println(count+"seller added succussfully");
		 
		 //close all connections
		 ps.close();	
   	 con.close();
		
	}
	public void updateSeller(Long sellerid)throws Exception {
		
		 //calling method of getConnection in ConnectionManager class	 
		 con=cm.getConnection();
		 
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE sellerdetails SET firstname=?,lastname=?,email=?,phone=? where USERID="+sellerid);
		 
		 //taking input from user
	     System.out.println("enter firstname");
	     String firstname=br.readLine(); 
	     System.out.println("enter lastname");
	     String lastname=br.readLine(); 
	     System.out.println("enter email");
	     String email=br.readLine();
	     System.out.println("enter phone number");
	     String phone=br.readLine();
	     
	     //setting values into table
	     ps.setString(1, firstname);
	     ps.setString(2, lastname);
	     ps.setString(3, email);
	     ps.setString(4, phone);
	    
	     //processing prepare statement
	     int count=ps.executeUpdate();
	     System.out.println(count+"seller updated succesfully");
	     
	     //closing all connections
			ps.close();	
	 	    con.close();
		
	}

	public void removeSeller(Long sellerid1)throws Exception {
		
		//calling method of getConnection in ConnectionManager class 
	     con=cm.getConnection();
	     
	     //creating prepare statement
	     PreparedStatement ps=con.prepareStatement("DELETE FROM sellerdetails where userID="+sellerid1);
	     
	     //executing prepare statement
	     int count=ps.executeUpdate();
	     
	     System.out.println(count+"seller deleted succusfully");
	     
	     //closing all connections
		 ps.close();	
	 	 con.close();
	}

	public void viewSellerList()throws Exception {
		
		//connection establishing
    	con=cm.getConnection();
    	String query="select * from sellerdetails ";
    	
    	//create statement
    	Statement st=con.createStatement();
    	
    	//execute statement
    	ResultSet rs=st.executeQuery(query);
    	System.out.println();
    	System.out.println("Users_id      Seller_firstname      Seller_lastname    Email    Phone_number");
    	System.out.println("__________________________________________________________________________________________");
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
        System.out.println("__________________________________________________________________________________________");
    	}
        //closing all connections
        st.close();
        con.close();
		
	}



	public void searchSeller(long sellerid2)throws Exception {
		
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	  System.out.println();
	  	  
	  	 //writing query
	  	  String query="select * from sellerdetails where  user_ID="+sellerid2;
	  	  
	  	//create statement
	    Statement st=con.createStatement();
	    	
	    //execute statement
	    ResultSet rs=st.executeQuery(query);
	    
	    if(rs.next()) {
	 		    		
	 		    	do {
	 		  	    
	 		  	    System.out.println("User_ID        firstname     lastname    email    phone  user_type");
	 		  	    System.out.println("____________________________________________________________________________");
	 		  	    System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"  "+rs.getString(4)+"    "+rs.getString(5)+"      "+rs.getString(6));
	 		    	}while(rs.next());
	
	 		    }
	 		    else {
	 		    		
	 		    		System.out.println("Sorry this seller not exist");
	 		    	}
	 	      
	  //closing statement
		    st.close();
		    con.close();
		
	}



	public void searchProduct(String productname)throws Exception {
		

		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	  System.out.println();
	  	  
	  	 //writing query
	  	  String query="select * from productdetails where productname='"+productname+"'";
	  	  
	  	//create statement
	    Statement st=con.createStatement();
	    	
	    //execute statement
	    ResultSet rs=st.executeQuery(query);
	    
	    if(rs.next()) {
	 		    		
	 		    	do {
	 		  	    
	 		  	    System.out.println("Product_ID  Product_Name  Rate/1KG  Quantity");
	 		  	 System.out.println("________________________________________________");
	 		  	    System.out.println(rs.getLong(1)+"      "+rs.getString(2)+"        "+rs.getFloat(3)+"       "+rs.getLong(4));
	 		    	}while(rs.next());
	
	 		    }
	 		    else {
	 		    		
	 		    		System.out.println("Sorry this item out of stack");
	 		    	}
	 	      
	  //closing statement
		    st.close();
		    con.close();
		
		
	}
}