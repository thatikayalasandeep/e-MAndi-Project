package pdf;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import utility.ConnectionManager;

public class GeneratePDF {
	
	 //object creation
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	Connection con;
	ConnectionManager cm=new ConnectionManager();

	
	
 public void pdf(long id)throws Exception {
	 
	//calling method of getConnection in ConnectionManager class
		 con=cm.getConnection();
		 System.out.println();
		 
		 //writing query
		 String query="select * from order_product where buyer_ID="+id;
		//create statement
	 	Statement st=con.createStatement();
	 	
	 	//execute statement
	 	ResultSet rs=st.executeQuery(query);
	 	
	 	Document my_pdf_report=new Document();
	 	
	 	PdfWriter.getInstance(my_pdf_report,new FileOutputStream("BillReceipt.pdf"));
	 	my_pdf_report.open();
	 	
	 	Paragraph p1=new Paragraph("Prduct Oreder Clip    \n");
	 	p1.setAlignment(Paragraph.ALIGN_CENTER);
	 	my_pdf_report.add(p1);
	 	Paragraph l=new Paragraph("_________________________________________________________________");
	 	my_pdf_report.add(l);
	 	
	 	while(rs.next()) {
	 		String street=rs.getString(1);
	 		Paragraph g1=new Paragraph("Street    ="+street+  "\n");
	 		my_pdf_report.add(g1);
	 		String city=rs.getString(2);
	 		Paragraph g2=new Paragraph("City    ="+city+  "\n");
	 		my_pdf_report.add(g2);
	 		String state=rs.getString(3);
	 		Paragraph g3=new Paragraph("State    ="+state+  "\n");
	 		my_pdf_report.add(g3);
	 		long zip=rs.getLong(4);
	 		Paragraph g4=new Paragraph("ZIP Code    ="+zip+  "\n");
	 		my_pdf_report.add(g4);
	 		String paymentmethod=rs.getString(5);
	 		Paragraph g5=new Paragraph("Payment Method    ="+paymentmethod+  "\n");
	 		my_pdf_report.add(g5);
	 		long buyerid=rs.getLong(6);
	 		Paragraph g6=new Paragraph("Buyer ID    ="+buyerid+  "\n");
	 		my_pdf_report.add(g6);
	 		Date date=rs.getDate(7);
	 		Paragraph g7=new Paragraph("Date    ="+date+  "\n");
	 		my_pdf_report.add(g7);
	 		Object time=rs.getObject(8);
	 		Paragraph g8=new Paragraph("Time    ="+time+  "\n");
	 		my_pdf_report.add(g8);
	 		String itemname=rs.getString(9);
	 		Paragraph g9=new Paragraph("Item Name    ="+itemname+  "\n");
	 		my_pdf_report.add(g9);
	 		int quantity=rs.getInt(10);
	 		Paragraph g10=new Paragraph("Quantity    ="+quantity+  "\n");
	 		my_pdf_report.add(g10);
	 		float bill=rs.getFloat(11);
	 		Paragraph g11=new Paragraph("Amount    ="+bill+  "\n");
	 		my_pdf_report.add(g11);
	 	}
	 	
	 	//my_pdf_report closing
	 	my_pdf_report.close();
	 	
	 	
	 	//closing all connections
	 	st.close();
	 	con.close();
	 		
	 	}



public void salepdf(long id)throws Exception {
	
	
	//calling method of getConnection in ConnectionManager class
	 con=cm.getConnection();
	 System.out.println();
	 
	 //writing query
	 String query="select * from sale_product where sellerid="+id;
	//create statement
	Statement st=con.createStatement();
	
	//execute statement
	ResultSet rs=st.executeQuery(query);
	
	Document my_pdf_report=new Document();
	
	PdfWriter.getInstance(my_pdf_report,new FileOutputStream("AmountClip.pdf"));
	my_pdf_report.open();
	
	Paragraph p1=new Paragraph("Prduct Sale Clip    \n");
	p1.setAlignment(Paragraph.ALIGN_CENTER);
	my_pdf_report.add(p1);
	Paragraph l=new Paragraph("_________________________________________________________________");
	my_pdf_report.add(l);
	
	while(rs.next()) {
		
		Paragraph g1=new Paragraph("Seller ID    ="+id+  "\n");
		my_pdf_report.add(g1);
		String firstname=rs.getString(2);
		Paragraph g2=new Paragraph("FirstName    ="+firstname+  "\n");
		my_pdf_report.add(g2);
		String lastname=rs.getString(3);
		Paragraph g3=new Paragraph("LastName    ="+lastname+  "\n");
		my_pdf_report.add(g3);
		String vegetablename=rs.getString(4);
		Paragraph g4=new Paragraph("Vegetable    ="+vegetablename+  "\n");
		my_pdf_report.add(g3);
		int quantity=rs.getInt(5);
		Paragraph g5=new Paragraph("Quantity    ="+quantity+  "\n");
		my_pdf_report.add(g5);
		float amount=rs.getFloat(6);
		Paragraph g6=new Paragraph("Amount   ="+quantity+  "\n");
		my_pdf_report.add(g6);
		Date date=rs.getDate(7);
		Paragraph g7=new Paragraph("Date    ="+date+  "\n");
		my_pdf_report.add(g7);
	}
	
	//my_pdf_report closing
	my_pdf_report.close();
	
	
	//closing all connections
	st.close();
	con.close();

	
	
}
	
 }

