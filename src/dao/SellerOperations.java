package dao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import model.Feedback;
import pdf.GeneratePDF;
import utility.ConnectionManager;

public class SellerOperations {
	
	//object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();

	public void seeProfile(Long sellerid)throws Exception  {
		
		//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 System.out.println();
		 
		 //writing query
		 String query="select * from seller where seller_ID='"+sellerid+"'";
		//create statement
	 	Statement st=con.createStatement();
	 	
	 	//execute statement
	 	ResultSet rs=st.executeQuery(query);
	 	System.out.println();
	 	System.out.println("Seller_id    first_name      last_name   email     phone_number    password    confirm_password   city    state     zip ");
	 	System.out.println();
	 	
	 	while(rs.next()){
	 		
	 	//fetching values
	     System.out.println(rs.getLong(1)+"     "+rs.getString(2)+"     "+rs.getString(3)+"     "+rs.getString(4)+"   "+rs.getString(5)+"      "+rs.getString(6)+
	    		  "  "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getString(9)+"  "+rs.getLong(10));
	 	}
	     //closing all connections
	     st.close();
	     con.close();
		
	}

	public void editProfile(Long sellerid)throws Exception {

		 //calling method of getConnection in ConnectionManager class	 
		 con=cm.getConnection();
		 System.out.println();
		 
		 //creating prepare statement
		 PreparedStatement ps=con.prepareStatement("UPDATE seller SET seller_id=?,firstname=?,lastname=?,email=?,phone=?,password=?,confirmpassword=?,city=?,state=?,zip=? where seller_ID='"+sellerid+"'");
		 
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
	     
	}

	public void feedBack(Feedback feedback) throws Exception{
		
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

	public void saleProduct(long sellerid, String itemname)throws Exception {
	
		//calling method of getConnection in ConnectionManager class
	   	 con=cm.getConnection();
	   	 System.out.println();
	   
	   	 
	   	 //writing query
	 	  String query="select * from productdetails where productname='"+itemname+"'";
	 	  
	 	//create statement
	   Statement st=con.createStatement();
	   	
	   //execute statement
	   ResultSet rs=st.executeQuery(query);
	   
	   if(rs.next()) {
			    		
			    	do {
			    		
			    		//taking user inputs
			    		 System.out.println("Enter your fistname");
			    		 String  firstname=br.readLine();
			    		 System.out.println("Enter  your lastname");
			    		 String  lastname=br.readLine();
			    		  System.out.println("Enter quntity");
					      long quantity=Long.parseLong(br.readLine());
					      //calculating the bill
					      float rate=rs.getFloat(3);
			    		  float bill=rate*quantity;
					      System.out.println("Your Amount  "+bill);
			
			    		
			    		 //writing query
			    	   	 String query2="insert into sale_product(sellerid,fistname,lastname,vegetable_name,quantity,amount,saledate)values(?,?,?,?,?,?,?)";
			    			   
			    			   //generating local date object
			    			   	 LocalDate  localDate=LocalDate.now();
			    			     //get localDate and localTime object from above
			    			   	 
			    		 
			    			   	//covert Date,time values from local to sql
			    			   	 java.sql.Date date=java.sql.Date.valueOf(localDate);
			   
			    			   	 
			    			   	 
			    			   	 //creating prepare statement
			    			   	 PreparedStatement ps=con.prepareStatement(query2);
			    			   	 
			    			   	 //setting values into database
			    			     ps.setLong(1,sellerid);
			    			     ps.setString(2, firstname);
			    			     ps.setString(3, lastname);
			    			     ps.setString(4, itemname);
			    			     ps.setLong(5, quantity);
			    			     ps.setFloat(6,bill);
			    			     ps.setDate(7, date);
			    			  
			    			   	 //executing prepare statement
			    			   	 int count=ps.executeUpdate();
			    			   	 
			    				  System.out.println("You saled Succussfully completed, your  Welcome !");
			    				  System.out.println();
			    				  System.out.println("Do you want Amount reciept  Yes/No");
			    				  String clip=br.readLine();
			    				  if("Yes"==clip) {
			    					  System.out.println("Enter your seller id");
			    					  long id=Long.parseLong(br.readLine());
			    					  GeneratePDF gp=new GeneratePDF(); 
			    					  gp.salepdf(id);
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
	
	
}
	