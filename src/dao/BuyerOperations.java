package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.sql.Date;

import model.Cart;
import model.Feedback;
import model.OrderProduct;
import pdf.GeneratePDF;
import utility.ConnectionManager;

public class BuyerOperations {
	
	 //object creation
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Connection con;
		ConnectionManager cm=new ConnectionManager();

	public void seeProfile(Long buyerid) throws Exception{
	
	//calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 System.out.println();
	 
	 //writing query
	 String query="select * from Buyer where buyer_ID="+buyerid;
	//create statement
 	Statement st=con.createStatement();
 	
 	//execute statement
 	ResultSet rs=st.executeQuery(query);
 	System.out.println();
 	System.out.println("Buyer_id    first_name      last_name   email     phone_number    password    confirm_password   city    state     zip ");
 	System.out.println();
 	while(rs.next()){
 		
 	//fetching values
     System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"      "+rs.getString(4)+"      "+rs.getString(5)+"      "+rs.getString(6)+
    		  "  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getLong(10));
 	}
     //closing all connections
     st.close();
     con.close();
}

	public void editProfile(Long buyerid)throws Exception {
		
		 //calling method of getConnection in ConnectionManager class	 
		 con=cm.getConnection();
		 System.out.println();
		 
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE buyer SET Buyer_id=?,firstname=?,lastname=?,email=?,phone=?,password=?,confirmpassword=?,city=?,state=?,zip=? where buyer_ID="+buyerid);
		 
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
	     System.out.println("enter new/old confirm password number");
	     String confopassword=br.readLine();
	     System.out.println("enter your new/old city name");
	     String city=br.readLine();
	     System.out.println("enter your new/old state name");
	     String state=br.readLine();
	     System.out.println("enter your/old zip");
	     long zip=Long.parseLong(br.readLine());
	     
	     //setting values into table
	     ps.setLong(1, yourid);
	     ps.setString(2, firstname);
	     ps.setString(3, lastname);
	     ps.setString(4, email);
	     ps.setString(5, phone);
	     ps.setString(6, password);
	     ps.setString(7, confopassword);
	     ps.setString(8, city);
	     ps.setString(9, state);
	     ps.setLong(10, zip);
	    
	     //processing prepare statement
	     int count=ps.executeUpdate();
	     System.out.println(count+"row/s user updated succesfully");
	     
	     //closing all connections
		 ps.close();	
		 con.close();
	}
	public void viewVegetableInfo() throws Exception {
		 DirectorAdminOperations daop=new  DirectorAdminOperations(); 
		 daop.viewProductList();
	}

	public void orderProduct(OrderProduct product)throws Exception {
		
	//calling method of getConnection in ConnectionManager class
   	 con=cm.getConnection();
   	 System.out.println();
   
   	 
   	 //writing query
 	  String query="select * from productdetails where productname='"+product.getItemname()+"'";
 	  
 	//create statement
   Statement st=con.createStatement();
   	
   //execute statement
   ResultSet rs=st.executeQuery(query);
   
   if(rs.next()) {
		    		
		    	do {
		    		
		    		//taking user inputs
		    		  System.out.println("Enter quntity");
				      long quantity=Long.parseLong(br.readLine());
				      System.out.println("Enter your street address");
				      String street=br.readLine();
				      System.out.println("Enter your city");
				      String city=br.readLine();
				      System.out.println("Enter your State");
				      String state=br.readLine();
				      System.out.println("Enter your zip");
				      long zip=Long.parseLong(br.readLine());
				      System.out.println("Enter payment Method");
				      String paymentmethod=br.readLine();
				      
				      //calculating the bill
				      float rate=rs.getFloat(3);
		    		  float bill=rate*quantity;
				      System.out.println("Pay the Bill  "+bill);
			    	  float ubill=Float.parseFloat(br.readLine());
		    		
		    		 //writing query
		    	   	 String query2="insert into order_product(to_street,to_city,to_state,to_zip,paymenttype,buyer_id,dispatches_date,dispatches_time,vegetablename,quantity,money_paid)values(?,?,?,?,?,?,?,?,?,?,?)";
		    			   
		    			   //generating local time object
		    			   	 LocalDateTime  localDateTime=LocalDateTime.now();
		    			     //get localDate and localTime object from above
		    			   	 LocalDate localDate= localDateTime.toLocalDate();
		    			   	 LocalTime localTime=localDateTime.toLocalTime();
		    			   	 
		    			   	//covert Date,time values from local to sql
		    			   	 java.sql.Date date=java.sql.Date.valueOf(localDate);
		    			   	 java.sql.Time time=java.sql.Time.valueOf(localTime);
		    			   	 
		    			   	 
		    			   	 //creating prepare statement
		    			   	 PreparedStatement ps=con.prepareStatement(query2);
		    			   	 
		    			   	 //setting values into database
		    			     ps.setString(1,street);
		    			     ps.setString(2, city);
		    			     ps.setString(3, state);
		    			     ps.setLong(4, zip);
		    			     ps.setString(5, paymentmethod);
		    			     ps.setLong(6, product.getBuyerid());
		    			     ps.setDate(7, date);
		    			     ps.setObject(8, time);
		    			     ps.setString(9, product.getItemname());
		    			     ps.setLong(10, quantity);
		    			     ps.setFloat(11,bill);
		    			  
		    			   	 //executing prepare statement
		    			   	 int count=ps.executeUpdate();
		    			   	 
		    				  System.out.println("Your order Succussfully completed, your  Welcome !");
		    				  
		    				 System.out.println("Do you want bill reciept  Yes/No");
		    				  String clip=br.readLine();
		    				  if("Yes"==clip) {
		    					  System.out.println("Enter your id");
		    					  long id=Long.parseLong(br.readLine());
		    					  GeneratePDF gp=new GeneratePDF(); 
		    					  gp.pdf(id);
		    				  }
		    				  
		    				  ps.close();
		    					 
		    	}while(rs.next());

		    }
		    else {
		    		
		    		System.out.println("Sorry this item out of stack");
		    	}
			 //close all connections
              st.close();
		   	 con.close();   
	  }

	public void addCart(String item)throws Exception {
		
		
	 //calling method of getConnection in ConnectionManager class
  	 con=cm.getConnection();
  	 System.out.println();
  	 
  	 //writing query
	  String query="select * from productdetails where productname='"+item+"'";
	  
	//create statement
  Statement st=con.createStatement();
  	
  //execute statement
  ResultSet rs=st.executeQuery(query);
  
  if(rs.next()) {
  	
  	 do {
  	      //taking use inputs
  		  System.out.println("Enter quantity");
	      int quantity=Integer.parseInt(br.readLine());
	      System.out.println("Enter your id");
	      long buyer_id=Long.parseLong(br.readLine());
  		 
  		 
  	 //writing query
  	 String query1="insert into cart(quantity,product_name,buyer_ID)values(?,?,?)";
  	 
	 //creating prepare statement
   	 PreparedStatement ps=con.prepareStatement(query1);
 	 
 		  
 	  //setting values into 
 	  ps.setInt(1, quantity);
 	  ps.setString(2, item);
 	  ps.setLong(3, buyer_id);
 	   	 
 	   //executing prepare statement
 	   	 int count=ps.executeUpdate();
 	   	 
 	  System.out.println("Succussfully added to Cart");
 	  
 	//close connection	
 	 ps.close();
  	 }while(rs.next());
  }else {
	  System.out.print("Sorry this item out of stack");
  }
 	  
 	  //close all connections
     st.close();
 	 con.close();
	}
 
	public void undocart(String item1) throws Exception{
		
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	 System.out.println();

		 //creating prepare statement
	   	 PreparedStatement ps=con.prepareStatement("DELETE FROM cart where product_name="+item1);
		
         System.out.println("Succussfully done undo  Cart");
		 
		 //close all connections
		 ps.close();	
   	     con.close();
	   	 
	}

	public void feedBack(Feedback feedback)throws Exception {
		
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	  System.out.println();
	  	  
	  	 //writing query
	  	  String query="insert into your_feedback(user_id,rating,comments,suggestions)values(?,?,?,?)";
		
	  	 //creating prepare statement
		   	 PreparedStatement ps=con.prepareStatement(query);
			
	      System.out.println("THANK YOU SO MUCH FOR YOUR VALUABLE FEEDBAC !.....");
			 
			 //close all connections
			 ps.close();	
	   	     con.close();
	  	  
	  	  
	}

	public void searchItem(String vegetable)throws Exception{
	 
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	  System.out.println();
	  	  
	  	 //writing query
	  	  String query="select * from productdetails where productname='"+vegetable+"'";
	  	  
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

	public void viewCart()throws Exception {
		
		//calling method of getConnection in ConnectionManager class
	  	 con=cm.getConnection();
	  	 System.out.println();
	  	  
	  	 //writing query
	  	 String query="select * from cart ";
	  	  
	  	//create statement
	    Statement st=con.createStatement();
	    	
	    //execute statement
	    ResultSet rs=st.executeQuery(query);
	    
	    System.out.println();
    	System.out.println("Product_Name       Quantity      Buyer_id");
    	System.out.println("________________________________________________________________");
    	while(rs.next()){
    	//fetching values
        System.out.println(rs.getString(1)+"      "+ rs.getInt(2)+"           "+rs.getLong(3));
        System.out.println("__________________________________________________________________");
    	}
        //closing all connections
        st.close();
        con.close();
	  
	    
		
	}

	
}

	