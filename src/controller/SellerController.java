package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import dao.DirectorAdminOperations;
import dao.SellerOperations;
import model.DirectorAdmin;
import model.Feedback;
import model.OrderProduct;
import model.Seller;
import service.Log_In;
import service.Register;

public class SellerController {

	 //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	SellerOperations so=new SellerOperations();
	DirectorAdminOperations dao=new DirectorAdminOperations();

	 
	 //local variable
    Long sellerid;
    
	 public void sellerService() throws Exception {
    Log_In li=new Log_In(); 
		 
		 System.out.println("1.Register");
		 System.out.println("2.Log in");
		 //taking input from user
		 int input=Integer.parseInt(br.readLine());
		 System.out.println("===================================================");
		 
		 if(input == 1) {
			    System.out.println("Enter seller ID");
			    sellerid=Long.parseLong(br.readLine());
				System.out.println("Enter your first name");
				String firstname=br.readLine();
				System.out.println("Enter your last name");
				String lastname=br.readLine();
				System.out.println("Enter your Email");
				String email=br.readLine();
				System.out.println("enter your phone");
				String phone=br.readLine();
				System.out.println("Enter password");
				String password=br.readLine();
				System.out.println("Confirm passsword");
				String confpassword=br.readLine();
				System.out.println("enter your city");
				String city=br.readLine();
				System.out.println("enter your State");
				String state=br.readLine();
				System.out.println("enter your Zip");
				long zip=Long.parseLong(br.readLine());
				Seller seller=new Seller(sellerid,firstname,lastname,email,phone,password,confpassword,city,state,zip);
				 Register r=new  Register();
				r.sellerRegister(seller);
				}
		       else if(input==2) {
		    	   System.out.println("Enter your Email");
		    	   String email=br.readLine();
					System.out.println("Enter password");
					String password=br.readLine();
					Seller seller=new Seller(email, password);
			    li.sellerLogin(seller);
		     }
		       else {
			 System.out.println("Sorry you entered wrong");
			 
		 }
	 }

public void seller()throws Exception {

	int choice;
	do {
		
	System.out.println("1.View profile");
	System.out.println("2.Edit profile");
	System.out.println("3.view vegetable information");
	System.out.println("4.Search product");
	System.out.println("5.Sale the product");
	System.out.println("7.Give Feedback");
	System.out.println("8.Exit");
	choice=Integer.parseInt(br.readLine());
	
	switch(choice) {
	case 1:System.out.println("=======================================================");
	       System.out.println("Enter Your Id");
	       sellerid=Long.parseLong(br.readLine());
	       so.seeProfile(sellerid);
	       break;
	case 2:System.out.println("=======================================================");
	      System.out.println("Enter Your Id");
          sellerid=Long.parseLong(br.readLine());
          so.editProfile(sellerid);
	       break;
	case 3:System.out.println("=======================================================");
	       System.out.println();
           dao.viewProductList();
	       break;
	case 4:System.out.println("=======================================================");
	       System.out.println("enter vegetable name ");
           String productname3=br.readLine();
           dao.searchProduct(productname3);
     
	       break;
	case 5:System.out.println("=======================================================");
	     System.out.println("Enter your ID number");
        long sellerid=Long.parseLong(br.readLine());
        System.out.println("Enter vegetable name");
        String itemname=br.readLine();
        so.saleProduct(sellerid,itemname);
	
	     
	       break;
	case 6:System.out.println("=======================================================");
	       System.out.println("Enter your id ");
           long yourid=Long.parseLong(br.readLine());
           System.out.println("Give your Rating [OUT OF 5'*]");
           int rating=Integer.parseInt(br.readLine());
           System.out.println("Enter your comment");
           String comment=br.readLine();
           System.out.println("Any Suggestion");
           String suggestion=br.readLine();
           Feedback feedback=new Feedback(yourid,rating,comment,suggestion);
           so.feedBack(feedback);
	       break;
	case 7: System.out.println("THANK YOU....!");
	       Main m=new Main();
	       m.main(null);
           break;       
	  }
	}while(choice!=8 && choice<8);
	
   }
}