import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class hospital {

	public static void main(String[] args) {
	
		String url = "jdbc:sqlserver://localhost:1433;" +
				"databaseName=HotelDBMS;" +
				"encrypt=true;" + "trustServerCertificate=true";
				String user = "sa";
				String pass = "root";
				Scanner scanner = new Scanner(System.in);
//				System.out.println("enter name");
//				String name = scanner.next();
//				System.out.println("enter roll no");
//				Integer roll = scanner.nextInt();
//				System.out.println("enter class");
//				String cls = scanner.next();
				Connection con = null;
			
				try {
				// create a new table
				Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
				DriverManager.registerDriver(driver);
				con = DriverManager.getConnection(url, user, pass);
				Statement st = con.createStatement();
				
				
				String hotels = "CREATE TABLE hotels (" +
						"id INTEGER Primary Key, " +
						" hotel_name TEXT, " +
						" hotel_location TEXT, " +
						"created_date date, " +
						"updated_date date, " +
						"is_Active Bit not NULL)";
				
			
				
				
				
						String RoomType = "CREATE TABLE Room_Type( " +
						            "id INTEGER Primary Key, " +
						            " room_type_name TEXT not NULL, " +
						            "created_date date, " +
						            "updated_date date, " +
						            "is_Active Bit not NULL)";
						
						 String rooms = "CREATE TABLE Rooms(" +
						"id INTEGER Primary Key, " +
						"room_type_id INTEGER , " +
						"hotel_id INTEGER , " +
						" FOREIGN KEY (room_type_id) REFERENCES Room_Type(id) ," +
						" FOREIGN KEY (hotel_id) REFERENCES Hotels(id)," +
						"created_date date, " +
						         "updated_date date, " +
						         "is_Active Bit not NULL)";
						 
						 
						 
						String Guests = "CREATE TABLE Guests(" +
						"id INTEGER Primary Key, " +
						" guest_name TEXT not NULL, " +
						" guest_phone TEXT not NULL, " +
						" guest_payment_amount INTEGER not NULL, " +
						"room_id INTEGER, " +
						"hotel_id INTEGER , " +
						"FOREIGN KEY (room_id) REFERENCES Rooms(id) ,"+
						"FOREIGN KEY (hotel_id) REFERENCES Hotels(id) ,"+
						"created_date date, " +
						"updated_date date, " +
						"is_Active Bit not NULL)";
						
						
						
						
						String employeeType = "CREATE TABLE Employee_Type(" +
						"id INTEGER Primary Key, " +
						" employee_type_name TEXT, " +
						"created_date date, " +
						"updated_date date, " +
						"is_Active Bit not NULL)";
						
						
						
						String Employees = "CREATE TABLE Employees(" +
						"id INTEGER Primary Key, " +
						"employee_type_id INTEGER , " +
						"room_id INTEGER , " +
						"FOREIGN KEY (employee_type_id) REFERENCES Employee_Type(id) ,"+
						"FOREIGN KEY (room_id) REFERENCES Hotels(id) ,"+
						"created_date date, " +
						"updated_date date, " +
						"is_Active Bit not NULL)";



				// statments to create tables
				
//				st.executeUpdate(hotels);
//			st.executeUpdate(RoomType);
//			st.executeUpdate(rooms);
//			st.executeUpdate(Guests);
//			st.executeUpdate(employeeType);
//				st.executeUpdate(Employees);
				
		////// insert values to the tables
						
//				String sql = "insert into hotels values(1 ,'star','muscat','1995/02/03','1993/12/05','true')";
//				Integer m = st.executeUpdate(sql);
//			if (m >= 1) {
//			System.out.println("inserted successfully : " + sql);
//				} else {
//				System.out.println("insertion failed");
//				}
//				 String sql1 = "Select top 1 * from hotels ORDER BY ID DISC";
//				ResultSet resultSet = st.executeQuery(sql1);
	
							
		for(Integer i =3;i<=10000;i++) {
		String sql2 = "insert into hotels values ("+ i+",'hotel_name"+i.toString()+"','hotel_location"+i.toString()+
				"','2002/02/03','2021/12/05', 1)";
		Integer f = st.executeUpdate(sql2);
		if (f >= 1) {
		System.out.println("inserted successfully : " + sql2);
			} else {
		System.out.println("insertion failed");
			}}
		
			
		 
		
		
		
				
		con.close();
		} catch (Exception ex) {
		System.err.println(ex);
		}
			}
}
