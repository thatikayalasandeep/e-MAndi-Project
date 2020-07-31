package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import dao.DirectorAdminOperations;

public class visitorController {
	
	 //Object creation
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 DirectorAdminOperations da=new DirectorAdminOperations();
		
 public void visitor() throws Exception {
	 int user;
	 do {
	 System.out.println("1.View the vegetable information");
     System.out.println("2.Exit");
     user=Integer.parseInt(br.readLine());
     
     switch(user) {
     case 1:System.out.println("=======================================================");
	       da.viewProductList();
           break;
     case 2:
          System.out.println("THANK YOU....!");
          System.out.println("=======================================================");
          Main m=new Main();
          m.main(null);
           break;
     }
	 }while(user !=3 & user<3);
 }
}
