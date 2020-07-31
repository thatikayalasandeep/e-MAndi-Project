package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.BuyerController;
import model.Buyer;
import model.Seller;
import utility.ConnectionManager;

public class Register {
	
	//object creation
	BuyerController bc=new BuyerController();
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();
	Log_In li=new Log_In();
	
 public void buyerRegister(Buyer buyer)throws Exception {
	 
	 //calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 
	 //writing query
	 String query="insert into buyer(buyer_ID,firstname,lastname,email,phone,password,confirmpassword,city,state,zip)values(?,?,?,?,?,?,?,?,?,?)";
	 
	 //creating prepare statement
	 PreparedStatement ps=con.prepareStatement(query);
	 
	//setting into table
	 ps.setLong(1,buyer.getBuyerid());
	 ps.setString(2, buyer.getFirstname());
	 ps.setString(3, buyer.getLastname());
	 ps.setString(4, buyer.getEmail());
	 ps.setString(5, buyer.getPhone());
	 ps.setString(6, buyer.getPassword());
	 ps.setString(7, buyer.getConfpassword());
	 ps.setString(8, buyer.getCity());
	 ps.setString(9, buyer.getState());
	 ps.setLong(10, buyer.getZip());
	 
	 //processing prepare statement
	 int count=ps.executeUpdate();
	 
	 System.out.println("Registration successfully completed");
	 System.out.println("=============================================================");
	 System.out.println("Signin into your Accounct");
	 System.out.println();
	 System.out.println("Enter your Email");
	 String email=br.readLine();
	 System.out.println("Enter password");
     String password=br.readLine();
	 Buyer buyer1=new Buyer(email, password);
     li.buyerLogin(buyer1);
     
	 //close all connections
	 ps.close();	
	 con.close();
	 
 }

public void sellerRegister(Seller seller)throws Exception {
	 //calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 
	 //writing query
	 String query="insert into seller(seller_ID,firstname,lastname,email,phone,password,confirmpassword,city,state,zip)values(?,?,?,?,?,?,?,?,?,?)";
	 
	 //creating prepare statement
	 PreparedStatement ps=con.prepareStatement(query);
	 
	//setting into table
	 ps.setLong(1,seller.getSellerid());
	 ps.setString(2, seller.getFirstname());
	 ps.setString(3, seller.getLastname());
	 ps.setString(4, seller.getEmail());
	 ps.setString(5, seller.getPhone());
	 ps.setString(6, seller.getPassword());
	 ps.setString(7, seller.getConfpassword());
	 ps.setString(8, seller.getCity());
	 ps.setString(9, seller.getState());
	 ps.setLong(10, seller.getZip());
	 
	 //processing prepare statement
	 int count=ps.executeUpdate();
	 
	 System.out.println("Registration successfully completed");
	 System.out.println("=============================================================");
	 System.out.println("Signin into your Accounct");
	 System.out.println();
	 System.out.println("Enter your Email");
	 String email=br.readLine();
	 System.out.println("Enter password");
     String password=br.readLine();
	 Seller seller1=new Seller(email, password);
    li.sellerLogin(seller1);
    
    //close all connections
	 ps.close();	
	 con.close();
}

}
