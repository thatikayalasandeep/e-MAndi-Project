package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import dao.DirectorAdminOperations;
import service.Log_In;

public class Main {

	public static void main(String[] args) throws Exception {
		
		//generate local date and time
		LocalDateTime ldt=LocalDateTime.now();
		
		//DateTime formating
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd-MM-yyyy  HH:mm:ss");
		
		
		System.out.println();
		System.out.println("======================================================================================================================");
		System.out.println("                        WELCOME TO ELECTRONIC VEGETABLE MARKERT                           Date: "+ldt.format(dtf));
		System.out.println("======================================================================================================================");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int choice;
		
		while(true) {
			System.out.println("1.Director-Admin");
			System.out.println("2.Buyer");
			System.out.println("3.Seller");
			System.out.println("4.Visitor");
			
			//taking user input
			choice=Integer.parseInt(br.readLine());
			switch(choice) {
			
			case 1:System.out.println();
				   System.out.println("=====================================================================================");
				   System.out.println("Signin into your Account");
				   System.out.println();
				   System.out.println("Enter your Email");
				   String email=br.readLine();
				   System.out.println("Enter password");
				   String password=br.readLine();
				   Log_In li=new Log_In();
				   li.adminLogin(email, password);
			       break;
			case 2:System.out.println("====================================================");
			       BuyerController bc=new BuyerController();
			       bc.buyerService();
			       System.out.println("====================================================");
			       break;
			case 3:System.out.println("====================================================");
			       SellerController sc=new SellerController();
			       sc.sellerService();
			       System.out.println("====================================================");
	               break;
			case 4:System.out.println("====================================================");
			      visitorController vc=new visitorController();
			      vc.visitor();
                   break;        
		 default:System.out.println("You entered wrong one!");
				   break;    
			}
		}
		
	}

}

