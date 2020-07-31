package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;
import java.time.LocalDate;

import model.Buyer;
import model.ProductDetails;
import model.SellerDetails;
import model.UserDetails;
import service.Log_In;
import dao.*;

public class DirectorAdminController {
	
	//Object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	DirectorAdminOperations da=new DirectorAdminOperations();

	
	public void directorAdmin() throws Exception {
		
		//local variables
		int choice;
		
		do {
		System.out.println();
		System.out.print("1.View profile       ");
		System.out.print("2.Edit profile       ");
		System.out.print("3.Add Buyer         ");
		System.out.print("4.Update Buyer      ");
		System.out.print("5.Remove Buyer      ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("6.View Buyers List    ");
		System.out.print("7.search for Buyer    ");
		System.out.print("8.Add Seller       ");
		System.out.print("9.Update Seller     ");
		System.out.print("10.Remove Seller     ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("11.View Sellers list    ");
		System.out.print("12.search for Seller    ");
		System.out.print("13.Add Product        ");
		System.out.print("14.Remove Product     ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.print("15.Update Product       ");
		System.out.print("16.View ProductList     ");
		System.out.print("17.Search Product       ");
		System.out.print("18.Exit    ");
		System.out.println();
		
		choice=Integer.parseInt(br.readLine());
		switch(choice) {
		
		case 1:System.out.println("=======================================================");
		       System.out.println("Enter your admin Id");
		       Long adminid=Long.parseLong(br.readLine()); 
		       da.viewProfile(adminid); 
		       System.out.println("=======================================================");
		       break;
		case 2:System.out.println("=======================================================");
	       System.out.println("Enter your admin Id");
	       long adminid1=Long.parseLong(br.readLine()); 
	       da.editProfile(adminid1); 
	       System.out.println("=======================================================");
	       break;       
		case 3:System.out.println("=======================================================");
		       System.out.println("enter user id");
		       Long userid=Long.parseLong(br.readLine()); 
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
		       UserDetails user=new UserDetails(userid,firstname,lastname,email,phone,usertype);
		       da.addUser(user);
		       System.out.println("Succesfull inserted user");
		       System.out.println("================================================================");
		       
		       break;
		case 4:System.out.println("=================================================================");
		      System.out.println("enter user_Id");
		      Long user_id=Long.parseLong(br.readLine());
		      da.updateUser(user_id);
		      System.out.println("================================================================");
		       break;
		case 5:System.out.println("==================================================================");
		       System.out.println("enter user_Id");
		       Long id_user=Long.parseLong(br.readLine());
		       da.removeUSer(id_user);
		       System.out.println("==================================================================");
		       break;
		case 6:System.out.println("===================================================================");
               da.viewUserList();
               System.out.println("===================================================================");
               break;
		case 7:System.out.println("==================================================================");
		       System.out.println("Enter buyer Id");
		       long buyer_id=Long.parseLong(br.readLine());
		       da.searchBuyer(buyer_id);
               System.out.println("====================================================================");
			     break;
			     
		case 8:System.out.println("==================================================================");
		       System.out.println("enter user id");
	           Long userid1=Long.parseLong(br.readLine()); 
	          System.out.println("enter firstname");
		       String firstname1=br.readLine(); 
		       System.out.println("enter lastname");
		       String lastname1=br.readLine(); 
		       System.out.println("enter email");
		       String email1=br.readLine(); 
		       System.out.println("enter phone number");
		       String phone1=br.readLine();
		       SellerDetails seller=new SellerDetails(userid1,firstname1,lastname1,email1,phone1);
		       da.addSeller(seller);
		       System.out.println("Succesfull inserted user");
		       System.out.println("==================================================================");
		        break;
		case 9:System.out.println("==================================================================");   
		       System.out.println("enter Seller_Id");
			   Long sellerid=Long.parseLong(br.readLine());
			   da.updateSeller(sellerid);
			   System.out.println("==================================================================");
			    break;
			    
		case 10:System.out.println("==================================================================");
	            System.out.println("enter seller_Id");
	            Long sellerid1=Long.parseLong(br.readLine());
	            da.removeSeller(sellerid1);
	            System.out.println("==================================================================");
	            break;
		case 11:System.out.println("===================================================================");
                da.viewSellerList();
                System.out.println("===================================================================");
                break;
		case 12:System.out.println("==================================================================");
	            System.out.println("Enter buyer Id");
	            long sellerid2=Long.parseLong(br.readLine());
	            da.searchSeller(sellerid2);
                System.out.println("====================================================================");
		        break;   
		case 13:System.out.println("===================================================================");
		       System.out.println("enter product id");
		       int productid=Integer.parseInt(br.readLine());
		       System.out.println("enter product name");
		       String productname=br.readLine();
		       System.out.println("enter product cost");
		       float productcost=Float.parseFloat(br.readLine());
		       System.out.println("enter product quantity");
		       long quantity=Long.parseLong(br.readLine());
		       ProductDetails product=new ProductDetails(productid,productname,productcost,quantity);
		       da.addProduct(product);
		       System.out.println("===================================================================");
		       break;       
		case 14:System.out.println("==================================================================_");
		      System.out.println("enter vegetable name ");
              String productname1=br.readLine();
		       da.removeProduc(productname1);
		       System.out.println("================================================================");
		       break;
		case 15:System.out.println("==================================================================");
		      System.out.println("enter vegetable name ");
	          String productname2=br.readLine();
	          da.productUpdate(productname2);
	          System.out.println("==================================================================");
		       break;
		case 16:System.out.println("==================================================================_");
		       da.viewProductList();
		       System.out.println("==================================================================_");
		       break;
		case 17:System.out.println("==================================================================_");
		        System.out.println("enter vegetable name ");
                String productname3=br.readLine();
	            da.searchProduct(productname3);
	            System.out.println("=====================================================================");
	       break; 
		case 18:System.out.println("==================================================================_");
               System.out.println("Thank you......!");
              Main m=new Main();
	            m.main(null);;
        System.out.println("=====================================================================");
   break; 
	       
		}
		}while(choice !=19 && choice >19);
	}	

}
