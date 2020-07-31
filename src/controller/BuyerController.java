package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import dao.BuyerOperations;
import model.Buyer;
import model.Cart;
import model.Feedback;
import model.OrderProduct;
import service.Log_In;
import service.Register;

public class BuyerController {
	
	 //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	 BuyerOperations bo=new BuyerOperations();
	 
	 //local variable
     Long buyerid;
     
	 public void buyerService() throws Exception {
     Log_In li=new Log_In(); 
		 
         System.out.println("Select your choice");
		 System.out.println("1.Register");
		 System.out.println("2.Log in");
		 //taking input from user
		 int input=Integer.parseInt(br.readLine());
		 System.out.println("===================================================");
		 
		 if(input == 1) {
			 System.out.println("Enter buyer ID");
			   buyerid=Long.parseLong(br.readLine());
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
				Buyer buyer=new Buyer(buyerid,firstname,lastname,email,phone,password,confpassword,city,state,zip);
				 Register r=new  Register();
				r.buyerRegister(buyer);
				}
		       else if(input==2) {
		    	   System.out.println("Signin into your Account");
		    	   System.out.println();
		    	   System.out.println("Enter your Email");
		    	   String email=br.readLine();
				   System.out.println("Enter password");
				   String password=br.readLine();
				   Buyer buyer=new Buyer(email, password);
			       li.buyerLogin(buyer);
		     }
		       else {
			 System.out.println("Sorry you entered wrong");
			 
		 }
		 
	 }
	public void buyer() throws Exception {
		int choice;
		do {
		System.out.println();	
		System.out.println("1.View profile");
		System.out.println("2.Edit profile");
		System.out.println("3.view the product information");
		System.out.println("4.Searach for item");
		System.out.println("5.Order item");
		System.out.println("6.Add to cart");
		System.out.println("7.view cart");
		System.out.println("8.Order cart item or undo cart item");
		System.out.println("9.Give Feedback");
		System.out.println("10.Exit");
		
		 choice=Integer.parseInt(br.readLine());
		
		switch(choice) {
		case 1:System.out.println("=======================================================");
		       System.out.println("Enter your ID");
		       buyerid=Long.parseLong(br.readLine());
		       bo.seeProfile(buyerid);
		       break;
		case 2:System.out.println("=======================================================");
		       System.out.println("Enter your ID");
		       buyerid=Long.parseLong(br.readLine());
		       bo.editProfile(buyerid);
		       System.out.println("Successfully edited your profile");
		       break;
		case 3:System.out.println("=======================================================");
		       System.out.println();
		       bo.viewVegetableInfo();
	           break;
		case 4:System.out.println("=======================================================");
	           System.out.println("Enter name of vegetable");
	           String vegetable=br.readLine();
	           System.out.println();
	           bo.searchItem(vegetable);
	           System.out.println("=======================================================");
               break;
	           
		case 5:System.out.println("=======================================================");
		      System.out.println("Enter your ID number");
		      long buyerid=Long.parseLong(br.readLine());
		      System.out.println("Enter vegetable name");
		      String itemname=br.readLine();
		      OrderProduct product=new OrderProduct(buyerid, itemname);
		      bo.orderProduct(product);
		      System.out.println("=======================================================");
	          break;
	   case 6:System.out.println("=======================================================");
		      System.out.println("Enter vegetable name");
		      String item=br.readLine();
		      bo.addCart(item);
		      System.out.println("=======================================================");
	          break;
	   case 7:System.out.println("=======================================================");
	         bo.viewCart();
              break;    
	   case 8:System.out.println("=======================================================");
		      System.out.println("1.order the cart item");
		      System.out.println("2.undo cart item");
		      int input=Integer.parseInt(br.readLine());
		      if(input==1){ 
		    	  System.out.println("Enter your ID number");
			      long buyerid1=Long.parseLong(br.readLine());
			      System.out.println("Enter vegetable name");
			      String itemname1=br.readLine();  
			      OrderProduct cartproduct=new OrderProduct(buyerid1, itemname1);
			      bo.orderProduct(cartproduct);
			      System.out.println("=======================================================");
		          }  
		          else if(input==2) {
		    	        System.out.println("Enter item to undo cart");
		    	        String item1=br.readLine();
		    	        bo.undocart(item1);
		    	 
		         }
		         else { 
		    	       System.out.println("you entered incorrect one");
		         }
		      
	              break;
		 case 9:System.out.println("=======================================================");
		        System.out.println("Enter your id ");
		        long yourid=Long.parseLong(br.readLine());
		        System.out.println("Give your Rating [OUT OF 5'*]");
		        int rating=Integer.parseInt(br.readLine());
		        System.out.println("Enter your comment");
		        String comment=br.readLine();
		        System.out.println("Any Suggestion");
		        String suggestion=br.readLine();
		        Feedback feedback=new Feedback(yourid,rating,comment,suggestion);
		        bo.feedBack(feedback);
		        
	            break;
		case 10:Main m=new Main();
		       m.main(null);;
	           break;
	           
		 }
		}while(choice!=11 && choice<11); 
		
	 }
}
