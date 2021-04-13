package com.tutoDocker.demoSpring;

import java.sql.*;
import java.util.ArrayList;

public class ClientAccess {

	public ClientAccess() {}
	
	public Client GET_CLIENT(int ID) throws Exception{
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://mysqldocker_mysql-db-test_1:3306/bank_data","root","helloworld");
		Statement stmt = conn.createStatement();
		
		String SQL_request = "SELECT * FROM helloworldbank WHERE id="+ID;
		
		ResultSet result_request = stmt.executeQuery(SQL_request);
		result_request.next();
		String clientFirstName = result_request.getString(1);
		String clientLastName = result_request.getString(2);
		int clientId = result_request.getInt(3);
		int clientAccount = result_request.getInt(4);
		
		Client requested_client = new Client(clientFirstName, clientLastName, clientId, clientAccount);
		requested_client.displayInfo();
		
		stmt.close();
		result_request.close();
		return requested_client;
	}
	
	
	public ArrayList<Client> GET_ALL_CLIENT() throws Exception{
		ArrayList<Client> requested_clients = new ArrayList<Client>();
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://mysqldocker_mysql-db-test_1:3306/bank_data","root","helloworld");
		Statement stmt = conn.createStatement();
		
		String SQL_request = "SELECT * FROM helloworldbank";
		
		ResultSet result_request = stmt.executeQuery(SQL_request);
		
		while(result_request.next()) {
			String clientFirstName = result_request.getString(1);
			String clientLastName = result_request.getString(2);
			int clientId = result_request.getInt(3);
			int clientAccount = result_request.getInt(4);
			
			Client requested_client = new Client(clientFirstName, clientLastName, clientId, clientAccount);
			requested_clients.add(requested_client);
		}
		
		stmt.close();
		result_request.close();
		return requested_clients;
		
	}
	
	public void CREATE_CLIENT(Client client_to_create) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://mysqldocker_mysql-db-test_1:3306/bank_data","root","helloworld");
		Statement stmt = conn.createStatement();
		
		String SQL_request = "INSERT into helloworldbank VALUES ('" +client_to_create.getFirstName()+"','"+client_to_create.getLastName()+"',"+client_to_create.getId()+","+client_to_create.getAccount()+")";
		
		int nbr_update = stmt.executeUpdate(SQL_request);
		System.out.println("CREATE - nombre d'update : " + nbr_update);
		stmt.close();
	
	}
	
	
	
	
	
	
}
